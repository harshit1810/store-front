/**
 * 
 */
package com.storebackend.common.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storebackend.common.bean.Product;

/**
 * @author hsriv
 *
 */
public interface ProductJPA extends JpaRepository<Product, Long> {

}
