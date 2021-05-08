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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "products")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_id_sequence_gen")
	@SequenceGenerator(name = "products_id_sequence_gen", sequenceName = "products_id_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(nullable = false)
	private int version;

	@Column(unique = true, updatable = false, nullable = false)
	private String key;

	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String description;

	@Column(nullable = false, unique = true)
	private String slug;

	@Column(nullable = false)
	private boolean published;

	// TODO: set transient until row mapper
	@Transient
	private List<String> keywords;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "product_type"), name = "product_type")
	private ProductType producttype;

	@JsonIgnore
	@Transient
	private List<Category> categories;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@Transient
	private List<ProductVariant> variants;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "last_modified_at")
	private Date lastModifiedAt;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "last_modified_by")
	private Long lastModifiedBy;

	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param version
	 * @param key
	 * @param name
	 * @param description
	 * @param slug
	 * @param published
	 * @param keywords
	 * @param producttype
	 * @param categories
	 * @param variants
	 * @param createdAt
	 * @param lastModifiedAt
	 * @param createdBy
	 * @param lastModifiedBy
	 */
	public Product(Long id, int version, String key, String name, String description, String slug, boolean published,
			List<String> keywords, ProductType producttype, List<Category> categories, List<ProductVariant> variants,
			Date createdAt, Date lastModifiedAt, Long createdBy, Long lastModifiedBy) {
		super();
		this.id = id;
		this.version = version;
		this.key = key;
		this.name = name;
		this.description = description;
		this.slug = slug;
		this.published = published;
		this.keywords = keywords;
		this.producttype = producttype;
		this.categories = categories;
		this.variants = variants;
		this.createdAt = createdAt;
		this.lastModifiedAt = lastModifiedAt;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * @return the published
	 */
	public boolean isPublished() {
		return published;
	}

	/**
	 * @param published the published to set
	 */
	public void setPublished(boolean published) {
		this.published = published;
	}

	/**
	 * @return the keywords
	 */
	public List<String> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @return the variants
	 */
	public List<ProductVariant> getVariants() {
		return variants;
	}

	/**
	 * @param variants the variants to set
	 */
	public void setVariants(List<ProductVariant> variants) {
		this.variants = variants;
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
	 * @return the producttype
	 */
	public ProductType getProducttype() {
		return producttype;
	}

	/**
	 * @param producttype the producttype to set
	 */
	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", version=" + version + ", key=" + key + ", name=" + name + ", description="
				+ description + ", slug=" + slug + ", published=" + published + ", keywords=" + keywords
				+ ", producttype=" + producttype + ", categories=" + categories + ", variants=" + variants
				+ ", createdAt=" + createdAt + ", lastModifiedAt=" + lastModifiedAt + ", createdBy=" + createdBy
				+ ", lastModifiedBy=" + lastModifiedBy + "]";
	}

}
