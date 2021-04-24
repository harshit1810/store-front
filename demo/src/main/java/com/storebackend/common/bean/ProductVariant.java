/**
 * 
 */
package com.storebackend.common.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String sku;

	@Column(name = "variant_id")
	private int variantId;

	/**
	 * TODO: set as transient until row mapper
	 */
	@Transient
	private List<String> images;

	@Column(name = "is_master")
	private boolean isMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "product_id"), name = "product_id")
	private Product product;

	@OneToMany(mappedBy = "productvariant", cascade = CascadeType.ALL)
	@Transient
	private List<ProductVariantAttribute> productVariantAttributes;

	@OneToMany(mappedBy = "variant", cascade = CascadeType.ALL)
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
	 * @param product
	 * @param productVariantAttributes
	 * @param prices
	 */
	public ProductVariant(String sku, int variantId, List<String> images, boolean isMaster, Product product,
			List<ProductVariantAttribute> productVariantAttributes, List<Price> prices) {
		super();
		this.sku = sku;
		this.variantId = variantId;
		this.images = images;
		this.isMaster = isMaster;
		this.product = product;
		this.productVariantAttributes = productVariantAttributes;
		this.prices = prices;
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
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
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
	 * @return the attributes
	 */
	public List<ProductVariantAttribute> getAttributes() {
		return productVariantAttributes;
	}

	/**
	 * @param productVariantAttributes the attributes to set
	 */
	public void setAttributes(List<ProductVariantAttribute> productVariantAttributes) {
		this.productVariantAttributes = productVariantAttributes;
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
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the productVariantAttributes
	 */
	public List<ProductVariantAttribute> getProductVariantAttributes() {
		return productVariantAttributes;
	}

	/**
	 * @param productVariantAttributes the productVariantAttributes to set
	 */
	public void setProductVariantAttributes(List<ProductVariantAttribute> productVariantAttributes) {
		this.productVariantAttributes = productVariantAttributes;
	}

	@Override
	public String toString() {
		return "ProductVariant [sku=" + sku + ", variantId=" + variantId + ", images=" + images + ", isMaster="
				+ isMaster + ", product=" + product + ", productVariantAttributes=" + productVariantAttributes
				+ ", prices=" + prices + "]";
	}

}
