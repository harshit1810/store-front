/**
 * 
 */
package com.storebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storebackend.common.bean.ProductVariantAttribute;
import com.storebackend.common.jpa.ProductVariantAttributeJPA;

/**
 * @author hsriv
 *
 */
@Service
public class ProductVariantAttributeService {

	@Autowired
	ProductVariantAttributeJPA repo;

	public List<ProductVariantAttribute> saveMany(List<ProductVariantAttribute> attributes) {
		return repo.saveAll(attributes);
	}
}
