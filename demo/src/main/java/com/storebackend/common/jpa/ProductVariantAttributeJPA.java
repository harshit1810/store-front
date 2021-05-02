/**
 * 
 */
package com.storebackend.common.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storebackend.common.bean.ProductVariantAttribute;

/**
 * @author hsriv
 *
 */
public interface ProductVariantAttributeJPA extends JpaRepository<ProductVariantAttribute, Long> {

}
