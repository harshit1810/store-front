/**
 * 
 */
package com.storebackend.common.bean;

/**
 * @author hsriv
 *
 */
public class ProductVariant extends BaseEntity {

	/**
	 * 
	 */
	public ProductVariant() {
		// TODO Auto-generated constructor stub
	}

	private String sku;
	private String[] images;
	private boolean isMaster;
	private Attribute[] attributes;
	private Price[] prices;
}
