/**
 * 
 */
package com.storebackend.common.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storebackend.common.bean.Customer;

/**
 * @author hsriv
 *
 */
public interface CustomerJPA extends JpaRepository<Customer, Long> {

	public List<Customer> findByUsername(String username);

}
