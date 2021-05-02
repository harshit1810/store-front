/**
 * 
 */
package com.storebackend.common.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storebackend.common.bean.Category;

/**
 * @author hsriv
 *
 */
public interface CategoryJPA extends JpaRepository<Category, Long> {

}
