/**
 * 
 */
package com.storebackend.common.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.storebackend.common.bean.Price;

/**
 * @author hsriv
 *
 */
public interface PriceJPA extends JpaRepository<Price, Long>, QueryByExampleExecutor<Price> {

}
