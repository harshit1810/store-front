package com.storebackend.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6040288491657900307L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_sequence_gen")
	@SequenceGenerator(name = "category_id_sequence_gen", sequenceName = "categories_id_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column
	private int version;

	@Column
	private String key;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private int level;

	@Column
	private boolean published;

	@Column
	private Long parent;

//	@Column
	@Transient
	private List<String> images;

//	@Column
	@Transient
	private List<String> banners;

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
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param version
	 * @param key
	 * @param name
	 * @param description
	 * @param level
	 * @param published
	 * @param parent
	 * @param images
	 * @param banners
	 * @param createdAt
	 * @param lastModifiedAt
	 * @param createdBy
	 * @param lastModifiedBy
	 */
	public Category(Long id, int version, String key, String name, String description, int level, boolean published,
			Long parent, List<String> images, List<String> banners, Date createdAt, Date lastModifiedAt, Long createdBy,
			Long lastModifiedBy) {
		super();
		this.id = id;
		this.version = version;
		this.key = key;
		this.name = name;
		this.description = description;
		this.level = level;
		this.published = published;
		this.parent = parent;
		this.images = images;
		this.banners = banners;
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
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
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
	 * @return the parent
	 */
	public Long getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Long parent) {
		this.parent = parent;
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
	 * @return the banners
	 */
	public List<String> getBanners() {
		return banners;
	}

	/**
	 * @param banners the banners to set
	 */
	public void setBanners(List<String> banners) {
		this.banners = banners;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", version=" + version + ", key=" + key + ", name=" + name + ", description="
				+ description + ", level=" + level + ", published=" + published + ", parent=" + parent + ", images="
				+ images + ", banners=" + banners + ", createdAt=" + createdAt + ", lastModifiedAt=" + lastModifiedAt
				+ ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + "]";
	}

}
