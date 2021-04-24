/**
 * 
 */
package com.storebackend.common.bean;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "prices")
public class Price implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2762962522115465940L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prices_id_sequence_gen")
	@SequenceGenerator(name = "prices_id_sequence_gen", sequenceName = "prices_id_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "variant_sku"), name = "variant_sku")
	private ProductVariant variant;

	@Column(name = "valid_from")
	private Date validFrom;

	@Column(name = "valid_to")
	private Date validTo;

	@Column
	private float amount;

	@Column(name = "discount_amount")
	private float discountAmount;

	/**
	 * 
	 */
	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param variant
	 * @param validFrom
	 * @param validTo
	 * @param amount
	 * @param discountAmount
	 */
	public Price(Long id, ProductVariant variant, Date validFrom, Date validTo, float amount, float discountAmount) {
		super();
		this.id = id;
		this.variant = variant;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.amount = amount;
		this.discountAmount = discountAmount;
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
	 * @return the variant
	 */
	public ProductVariant getVariant() {
		return variant;
	}

	/**
	 * @param variant the variant to set
	 */
	public void setVariant(ProductVariant variant) {
		this.variant = variant;
	}

	/**
	 * @return the validFrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * @return the validTo
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/**
	 * @return the discountAmount
	 */
	public float getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", variant=" + variant + ", validFrom=" + validFrom + ", validTo=" + validTo
				+ ", amount=" + amount + ", discountAmount=" + discountAmount + "]";
	}

}
