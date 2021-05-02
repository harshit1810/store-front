/**
 * 
 */
package com.storebackend.common.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author hsriv
 *
 */
@Entity
@Table(name = "product_variants")
public class ProductVariant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 633408481419065860L;

	@Id
	private int sku;

	@Column(name = "variant_id")
	private int variantId;

	@Transient
	private List<String> images;

	@Column(name = "is_master")
	private boolean isMaster;

	@Transient
	private List<Attribute> attributes;

	@Transient
	private List<Price> prices;

	/**
	 * 
	 */
	public ProductVariant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sku
	 * @param variantId
	 * @param images
	 * @param isMaster
	 * @param attributes
	 * @param prices
	 */
	public ProductVariant(int sku, int variantId, List<String> images, boolean isMaster, List<Attribute> attributes,
			List<Price> prices) {
		super();
		this.sku = sku;
		this.variantId = variantId;
		this.images = images;
		this.isMaster = isMaster;
		this.attributes = attributes;
		this.prices = prices;
	}

	/**
	 * @return the sku
	 */
	public int getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(int sku) {
		this.sku = sku;
	}

	/**
	 * @return the variantId
	 */
	public int getVariantId() {
		return variantId;
	}

	/**
	 * @param variantId the variantId to set
	 */
	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}

	/**
	 * @return the images
	 */
	public List<String> getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(List<String> images) {
		this.images = images;
	}

	/**
	 * @return the isMaster
	 */
	public boolean isMaster() {
		return isMaster;
	}

	/**
	 * @param isMaster the isMaster to set
	 */
	public void setMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}

	/**
	 * @return the attributes
	 */
	public List<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the prices
	 */
	public List<Price> getPrices() {
		return prices;
	}

	/**
	 * @param prices the prices to set
	 */
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductVariant [sku=" + sku + ", variantId=" + variantId + ", images=" + images + ", isMaster="
				+ isMaster + ", attributes=" + attributes + ", prices=" + prices + "]";
	}

}
