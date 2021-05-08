/**
 * 
 */
package com.storebackend.producttype.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storebackend.common.bean.AttributeDefinition;
import com.storebackend.common.bean.ProductType;
import com.storebackend.common.jpa.AttributeDefinitionJPA;
import com.storebackend.common.jpa.ProductTypeJPA;
import com.storebackend.common.util.CommonConstants;
import com.storebackend.producttype.util.ProductTypeConstants;

/**
 * @author hsriv
 *
 */
@RestController
@RequestMapping(value = "/" + CommonConstants.ApiLabel + "/" + ProductTypeConstants.ApiVersion + "/product-types")
public class ProductTypeController {
	
	Logger log= LoggerFactory.getLogger(ProductTypeController.class);

	@Autowired
	ProductTypeJPA productTypeJpa;

	@Autowired
	AttributeDefinitionJPA attributeDefinitionJpa;

	/**
	 * @return the productTypeJpa
	 */
	public ProductTypeJPA getProductTypeJpa() {
		return productTypeJpa;
	}

	/**
	 * @param productTypeJpa the productTypeJpa to set
	 */
	public void setProductTypeJpa(ProductTypeJPA productTypeJpa) {
		this.productTypeJpa = productTypeJpa;
	}

	/**
	 * @return the attributeDefinitionJpa
	 */
	public AttributeDefinitionJPA getAttributeDefinitionJpa() {
		return attributeDefinitionJpa;
	}

	/**
	 * @param attributeDefinitionJpa the attributeDefinitionJpa to set
	 */
	public void setAttributeDefinitionJpa(AttributeDefinitionJPA attributeDefinitionJpa) {
		this.attributeDefinitionJpa = attributeDefinitionJpa;
	}

	@GetMapping(value = "/greet", produces = "text/plain")
	public String greet() {
		return "Hello World!";
	}

	@GetMapping(value = "/", produces = "application/json")
	public List<ProductType> getProductTypes() {
		List<ProductType> results = productTypeJpa.findAll();
		System.out.println("Product types found = " + results);
		return results;
	}

	@PostMapping(value = "/")
	public ResponseEntity<Integer> create(@RequestBody ProductType draft) {
		System.out.println("Product type draft = " + draft);

		ProductType saved = null;
		// save product type
		try {
			saved = productTypeJpa.save(
					new ProductType(null, draft.getKey(), 1, new Date(), null, 1L, 1L, draft.getName(), null, null));
		} catch (Exception e) {
			System.out.println("Failed to create the product type");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// set product type id in attribute definitions
		List<AttributeDefinition> updatedDefs = new ArrayList<AttributeDefinition>();
		for (AttributeDefinition def : draft.getAttributeDefinitions()) {
			updatedDefs.add(new AttributeDefinition(null, def.getName(), def.getType(), def.isRequired(),
					def.isSearchable(), def.isSortable(), def.isFacetable(), saved));
		}

		// save attribute definitions
		attributeDefinitionJpa.saveAll(updatedDefs);
		return new ResponseEntity<Integer>(HttpStatus.CREATED);
	}
}
