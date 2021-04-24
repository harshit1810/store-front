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

@Entity
@Table(name = "product_type_attribute_definitions")
public class AttributeDefinition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7736181293073830211L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_def_id_sequence_gen")
	@SequenceGenerator(name = "attribute_def_id_sequence_gen", sequenceName = "product_type_attribute_definitions_id_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column
	private String name;

	@Column
	private String type;

	@Column
	private boolean required;

	@Column
	private boolean searchable;

	@Column
	private boolean sortable;

	@Column
	private boolean facetable;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "product_type_id"), name = "product_type_id")
	private ProductType producttype;

	/**
	 * 
	 */
	public AttributeDefinition() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param required
	 * @param searchable
	 * @param sortable
	 * @param facetable
	 * @param producttype
	 */
	public AttributeDefinition(Long id, String name, String type, boolean required, boolean searchable,
			boolean sortable, boolean facetable, ProductType producttype) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.required = required;
		this.searchable = searchable;
		this.sortable = sortable;
		this.facetable = facetable;
		this.producttype = producttype;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the required
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * @param required the required to set
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * @return the searchable
	 */
	public boolean isSearchable() {
		return searchable;
	}

	/**
	 * @param searchable the searchable to set
	 */
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	/**
	 * @return the sortable
	 */
	public boolean isSortable() {
		return sortable;
	}

	/**
	 * @param sortable the sortable to set
	 */
	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	/**
	 * @return the facetable
	 */
	public boolean isFacetable() {
		return facetable;
	}

	/**
	 * @param facetable the facetable to set
	 */
	public void setFacetable(boolean facetable) {
		this.facetable = facetable;
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
		return "AttributeDefinition [id=" + id + ", name=" + name + ", type=" + type + ", required=" + required
				+ ", searchable=" + searchable + ", sortable=" + sortable + ", facetable=" + facetable
				+ ", producttype=" + producttype + "]";
	}

}
