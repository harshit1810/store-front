/**
 * 
 */
package com.storebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storebackend.common.bean.ProductVariant;
import com.storebackend.common.jpa.ProductVariantJPA;

/**
 * @author hsriv
 *
 */
@Service
public class ProductVariantService {

	@Autowired
	ProductVariantJPA repo;

	public ProductVariant create(ProductVariant obj) {
		return repo.save(obj);
	}
}
