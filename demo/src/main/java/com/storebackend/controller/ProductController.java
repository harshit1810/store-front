/**
 * 
 */
package com.storebackend.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storebackend.common.bean.Price;
import com.storebackend.common.bean.Product;
import com.storebackend.common.bean.ProductType;
import com.storebackend.common.bean.ProductVariant;
import com.storebackend.common.bean.ProductVariantAttribute;
import com.storebackend.common.jpa.ProductTypeJPA;
import com.storebackend.common.jpa.ProductVariantJPA;
import com.storebackend.common.util.CommonConstants;
import com.storebackend.service.PriceService;
import com.storebackend.service.ProductService;
import com.storebackend.service.ProductVariantAttributeService;
import com.storebackend.service.ProductVariantService;

/**
 * @author hsriv
 *
 */
@RestController
@RequestMapping(value = CommonConstants.ProductService_Path)
public class ProductController {

	Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService service;

	@Autowired
	ProductVariantJPA productVariant;

	@Autowired
	ProductTypeJPA productType;

	@Autowired
	ProductVariantService variantService;

	@Autowired
	ProductVariantAttributeService variantAttributeService;

	@Autowired
	PriceService priceService;

	/**
	 * @return the productVariant
	 */
	public ProductVariantJPA getProductVariant() {
		return productVariant;
	}

	/**
	 * @param productVariant the productVariant to set
	 */
	public void setProductVariant(ProductVariantJPA productVariant) {
		this.productVariant = productVariant;
	}

	/**
	 * @return the productType
	 */
	public ProductTypeJPA getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(ProductTypeJPA productType) {
		this.productType = productType;
	}

	/**
	 * Query all products
	 * 
	 * @return Paginated list based on criteria
	 */
	@GetMapping(value = CommonConstants.ProductService_Path_Find, produces = "application/json")
	public ResponseEntity<List<Product>> find(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "20", required = false) int size,
			@RequestParam(name = "published", defaultValue = "true", required = false) boolean published,
			@RequestParam(name = "skip", defaultValue = "0", required = false) long skip) {

		List<Product> matchingProducts = new ArrayList<Product>();
		try {
			matchingProducts = service.find(page, size, published, skip);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(matchingProducts, HttpStatus.OK);
	}

	/**
	 * Get one product by its ID
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = CommonConstants.ProductService_Path_GetById, produces = "application/json")
	public Product getById(@PathVariable(name = "id") long id) {
		return service.getById(id);
	}

	/**
	 * Change the published status of a product
	 * 
	 * @param id
	 * @return
	 */
	@PatchMapping(value = CommonConstants.ProductService_Path_TogglePublish, consumes = "application/json")
	public ResponseEntity<Integer> deleteById(@PathVariable(name = "id") long id, @RequestBody PatchPublished obj) {
		Product _existing = service.getById(id);
		_existing.setPublished(obj.isPublished());
		service.save(_existing);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	/**
	 * Create a product
	 * 
	 * @param draft
	 * @return
	 */
	@PostMapping(value = CommonConstants.ProductService_Path_Create, consumes = "application/json")
	public ResponseEntity<Integer> create(@RequestBody Product draft) {
		log.info("Received product draft {} ", draft);

		/**
		 * validate product type
		 */
		try {
			Optional<ProductType> pType = productType.findById(draft.getProducttype().getId());
			ProductType foo = pType.get();
			draft.setProducttype(foo);
		} catch (IllegalArgumentException e1) {
			log.info("Product type not provided");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e2) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		/**
		 * check variants
		 */
		if (null == draft.getVariants() || draft.getVariants().isEmpty()) {
			log.error("Atleast one variant is required");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		/**
		 * TODO: Skip until fixed
		 */
//		Optional<ProductVariant> masterVariant = draft.getVariants().stream().filter(v -> v.isMaster()).findFirst();
//		if (!masterVariant.isPresent()) {
//			log.error("A master variant is required to create a product");
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		}
		/**
		 * HOTFIX: mark first variant as master
		 */
		ProductVariant masterVariant = draft.getVariants().get(0);
		masterVariant.setMaster(true);

		/**
		 * validate variant prices
		 */
		boolean variantsHavePrices = draft.getVariants().stream()
				.allMatch(v -> null != v.getPrices() && !v.getPrices().isEmpty());
		if (!variantsHavePrices) {
			log.error("One or more variants in product {} do not have valid price", draft.getName());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		for (ProductVariant v : draft.getVariants()) {
			List<Price> prices = v.getPrices();
			for (Price p : prices) {
				if (p.getAmount() < 0) {
					log.error("Variant price cannot be less than 0");
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}
			}
		}

		/**
		 * save product
		 */
		draft.setVersion(CommonConstants.DefaultEntityVersion);
		draft.setSlug(draft.getName().trim().toLowerCase().replaceAll("\\s+", "-").concat(masterVariant.getSku()));
		draft.setCreatedAt(new Date());
		draft.setCreatedBy(CommonConstants.DefaultCreatedBy);
		Product newProduct = null;
		try {
			newProduct = service.save(draft);
		} catch (Exception e3) {
			log.info("Failed to create product {} : {}", draft.getKey(), e3.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		/**
		 * Save product variants and their attributes
		 */
		List<ProductVariant> createdVariants = new ArrayList<ProductVariant>();
		try {
			// for each variant
			for (ProductVariant _variant : draft.getVariants()) {
				_variant.setVariantId(createdVariants.size());
				_variant.setProduct(newProduct);

				// create the variant
				ProductVariant createdVariant = null;
				try {
					createdVariant = variantService.create(_variant);
					log.info("Variant {} created for product {}", createdVariant.getSku(), newProduct.getName());
					createdVariants.add(createdVariant);
				} catch (Exception variantCreateError) {
					log.error("Failed to create variant {}", _variant.getSku());
					throw variantCreateError;
				}

				// save its prices
				for (Price priceDraft : _variant.getPrices()) {
					priceDraft.setVariant(createdVariant);
				}
				try {
					priceService.saveMultiple(_variant.getPrices());
					log.info("{} prices created for sku {}", _variant.getPrices().size(), createdVariant.getSku());
				} catch (Exception savePricesError) {
					log.error("Failed to save prices for variant {}", _variant.getSku());
					_variant.setPrices(new ArrayList<Price>());
				}

				// save its attributes
				for (ProductVariantAttribute attr : _variant.getAttributes()) {
					attr.setProductvariant(createdVariant);
				}
				try {
					variantAttributeService.saveMany(_variant.getAttributes());
				} catch (Exception variantAttributesCreateError) {
					log.error("Failed to save attributes for variant {}", createdVariant.getSku());
					throw variantAttributesCreateError;
				}

			}
		} catch (Exception variantCreateError) {
			service.unPublishProduct(newProduct.getId());
		}

		return new ResponseEntity<Integer>(HttpStatus.CREATED);
	}

	private class PatchPublished {
		private boolean published;

		/**
		 * @return the published
		 */
		public boolean isPublished() {
			return published;
		}

	}
}