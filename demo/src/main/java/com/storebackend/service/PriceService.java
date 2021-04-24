/**
 * 
 */
package com.storebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.storebackend.common.bean.Price;
import com.storebackend.common.bean.ProductVariant;
import com.storebackend.common.jpa.PriceJPA;

/**
 * @author hsriv
 *
 */
@Service
public class PriceService {

	@Autowired
	PriceJPA repo;

	public Price save(Price price) {
		return repo.save(price);
	}

	public List<Price> saveMultiple(List<Price> prices) {
		return repo.saveAll(prices);
	}

	public List<Price> getBySku(String sku) {
		Example<Price> ex = Example.of(new Price() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				setVariant(new ProductVariant() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					{
						setSku(sku);
					}
				});
			}
		});
		return repo.findAll(ex);
	}

}
