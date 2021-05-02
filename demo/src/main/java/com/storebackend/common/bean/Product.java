/**
 * 
 */
package com.storebackend.common.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author hsriv
 *
 */
@Entity(name = "producttype")
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private String slug;
	private boolean published;
	private String[] keywords;
	private String productType; // id of product type
	private String[] categories; // ids of categories
	private ProductVariant[] variants;
}
