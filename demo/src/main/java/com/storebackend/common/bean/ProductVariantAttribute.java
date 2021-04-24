/**
 * 
 */
package com.storebackend.common.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author hsriv
 *
 */
@Entity
@Table(name = "product_variant_attributes")
public class ProductVariantAttribute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6655379742296242345L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_variant_attr_id_sequence_gen")
	@SequenceGenerator(name = "product_variant_attr_id_sequence_gen", sequenceName = "product_variant_attribute_id_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column
	private String name;

	@Column
	private String value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "product_variant_sku"), name = "product_variant_sku")
	private ProductVariant productvariant;

	/**
	 * 
	 */
	public ProductVariantAttribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param value
	 * @param productvariant
	 */
	public ProductVariantAttribute(Long id, String name, String value, ProductVariant productvariant) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.productvariant = productvariant;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the productvariant
	 */
	public ProductVariant getProductvariant() {
		return productvariant;
	}

	/**
	 * @param productvariant the productvariant to set
	 */
	public void setProductvariant(ProductVariant productvariant) {
		this.productvariant = productvariant;
	}

	@Override
	public String toString() {
		return "ProductVariantAttribute [id=" + id + ", name=" + name + ", value=" + value + ", productvariant="
				+ productvariant + "]";
	}

}
