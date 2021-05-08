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

}
