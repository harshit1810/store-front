/**
 * 
 */
package com.storebackend.products.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.storebackend.common.bean.Product;
import com.storebackend.common.jpa.ProductJPA;
import com.storebackend.common.jpa.ProductVariantJPA;
import com.storebackend.common.util.CommonConstants;
import com.storebackend.products.util.ProductsConstants;

/**
 * @author hsriv
 *
 */
@RestController
@RequestMapping(value = "/" + CommonConstants.ApiLabel + "/" + ProductsConstants.ApiVersion + "/products")
public class ProductController {

	private class PatchPublished {
		private boolean published;

		/**
		 * @return the published
		 */
		public boolean isPublished() {
			return published;
		}

	}

	@Autowired
	ProductJPA product;

	@Autowired
	ProductVariantJPA productVariant;

	/**
	 * @return the product
	 */
	public ProductJPA getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductJPA product) {
		this.product = product;
	}

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
	 * Query all products
	 * 
	 * @return Paginated list based on criteria
	 */
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Product>> find(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "20", required = false) int size,
			@RequestParam(name = "published", defaultValue = "true", required = false) boolean published,
			@RequestParam(name = "skip", defaultValue = "0", required = false) long skip) {

		List<Product> matchingProducts = new ArrayList<Product>();
		try {
			Pageable paging = PageRequest.of(page, size);
			Page<Product> pagedResults = product.findAll(paging);
			matchingProducts = pagedResults.getContent();
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
	@GetMapping(value = "/{id}", produces = "application/json")
	public Product getById(@PathVariable(name = "id") long id) {
		return product.getOne(id);
	}

	/**
	 * Change the published status of a product
	 * 
	 * @param id
	 * @return
	 */
	@PatchMapping(value = "/{id}/publish", consumes = "application/json")
	public ResponseEntity<Integer> deleteById(@PathVariable(name = "id") long id, @RequestBody PatchPublished obj) {
		Product _existing = this.product.getOne(id);
		_existing.setPublished(obj.isPublished());
		this.product.save(_existing);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = "application/json")
	public ResponseEntity<Integer> create(@RequestBody Product draft) {
		return new ResponseEntity<Integer>(HttpStatus.CREATED);
	}
}
