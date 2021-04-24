/**
 * 
 */
package com.storebackend.common.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storebackend.common.bean.ProductType;

/**
 * @author hsriv
 *
 */
public interface ProductTypeJPA extends JpaRepository<ProductType, Long> {

}
