/**
 * 
 */
package com.storebackend.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author hsriv
 *
 */
@Entity
@Table(name = "producttypes")
public class ProductType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5030791766927408172L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_type_id_sequence_gen")
	@SequenceGenerator(name = "product_type_id_sequence_gen", sequenceName = "product_type_id_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(nullable = false, unique = true, updatable = false)
	private String key;

	@Column(nullable = false)
	private int version;

	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "last_modified_at")
	private Date lastModifiedAt;

	@Column(name = "created_by", nullable = false)
	private Long createdBy;

	@Column(name = "last_modified_by")
	private Long lastModifiedBy;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "producttype", cascade = CascadeType.ALL)
	@JsonIgnore
	@Transient
	private List<AttributeDefinition> attributeDefinitions;

	@OneToMany(mappedBy = "producttype", cascade = CascadeType.ALL)
	@JsonIgnore
	@Transient
	private Product product;

	/**
	 * 
	 */
	public ProductType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param key
	 * @param version
	 * @param createdAt
	 * @param lastModifiedAt
	 * @param createdBy
	 * @param lastModifiedBy
	 * @param name
	 * @param attributeDefinitions
	 * @param product
	 */
	public ProductType(Long id, String key, int version, Date createdAt, Date lastModifiedAt, Long createdBy,
			Long lastModifiedBy, String name, List<AttributeDefinition> attributeDefinitions, Product product) {
		super();
		this.id = id;
		this.key = key;
		this.version = version;
		this.createdAt = createdAt;
		this.lastModifiedAt = lastModifiedAt;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.name = name;
		this.attributeDefinitions = attributeDefinitions;
		this.product = product;
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
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the lastModifiedAt
	 */
	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	/**
	 * @param lastModifiedAt the lastModifiedAt to set
	 */
	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
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
	 * @return the attributeDefinitions
	 */
	public List<AttributeDefinition> getAttributeDefinitions() {
		return attributeDefinitions;
	}

	/**
	 * @param attributeDefinitions the attributeDefinitions to set
	 */
	public void setAttributeDefinitions(List<AttributeDefinition> attributeDefinitions) {
		this.attributeDefinitions = attributeDefinitions;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", key=" + key + ", version=" + version + ", createdAt=" + createdAt
				+ ", lastModifiedAt=" + lastModifiedAt + ", createdBy=" + createdBy + ", lastModifiedBy="
				+ lastModifiedBy + ", name=" + name + ", attributeDefinitions=" + attributeDefinitions + ", product="
				+ product + "]";
	}

}
