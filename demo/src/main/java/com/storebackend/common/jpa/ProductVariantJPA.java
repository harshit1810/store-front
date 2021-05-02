/**
 * 
 */
package com.storebackend.common.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storebackend.common.bean.ProductVariant;

/**
 * @author hsriv
 *
 */
public interface ProductVariantJPA extends JpaRepository<ProductVariant, Integer> {

}
