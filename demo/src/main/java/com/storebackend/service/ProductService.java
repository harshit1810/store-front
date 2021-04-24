/**
 * 
 */
package com.storebackend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.storebackend.common.bean.Product;
import com.storebackend.common.jpa.ProductJPA;
import com.storebackend.common.util.CommonConstants;

/**
 * @author hsriv
 *
 */
@Service
public class ProductService {
	Logger log = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductJPA repo;

	/**
	 * @return the products
	 */
	public ProductJPA getProducts() {
		return repo;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(ProductJPA products) {
		this.repo = products;
	}

	public Product getById(Long id) {
		return repo.getOne(id);
	}

	public List<Product> find(int page, int size, boolean published, long skip) {
		List<Product> matchingProducts = new ArrayList<Product>();
		Pageable paging = PageRequest.of(page, size);
		Page<Product> pagedResults = repo.findAll(paging);
		matchingProducts = pagedResults.getContent();
		return matchingProducts;
	}

	public Product save(Product draft) {
		draft.setLastModifiedAt(new Date());
		draft.setLastModifiedBy(CommonConstants.DefaultCreatedBy);
		Product created = null;
		try {
			created = repo.save(draft);
			log.info("Product {} created ", draft.getName());
		} catch (IllegalArgumentException e) {
			log.error("Product draft is null");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return created;
	}

	public boolean unPublishProduct(Long id) {
		boolean result = false;
		Product prod = null;

		// fetch product
		try {
			prod = getById(id);
		} catch (Exception getErr) {
			log.error("Failed to get details for product {}", id);
			return result;
		}

		// update product
		try {
			prod.setPublished(false);
			Product updated = save(prod);
			result = updated.isPublished();
		} catch (Exception e) {
			log.error("Failed to unpublish product {}", prod.getId());
		}
		return result;
	}
}