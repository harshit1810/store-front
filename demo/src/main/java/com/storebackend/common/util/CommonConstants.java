/**
 * 
 */
package com.storebackend.common.util;

/**
 * @author hsriv
 *
 */
public final class CommonConstants {
	public static final String ApiLabel = "api";
	public static final long DefaultCreatedBy = 1;
	public static final int DefaultEntityVersion = 1;

	/**
	 * products service related
	 */
	public static final String ProductService_Name = "products";
	public static final String ProductService_Version = "v1";
	public static final String ProductService_Path = "/" + ApiLabel + "/" + ProductService_Name + "/"
			+ ProductService_Version;

	public static final String ProductService_Path_Create = "/";
	public static final String ProductService_Path_Find = "/";
	public static final String ProductService_Path_GetById = "/{id}";
	public static final String ProductService_Path_TogglePublish = "/{id}/publish";

	/**
	 * category service related
	 */
	public static final String CategoryService_Name = "categories";
	public static final String CategoryService_Version = "v1";
	public static final String CategoryService_Path = "/" + ApiLabel + "/" + CategoryService_Name + "/"
			+ CategoryService_Version;

	public static final String CategoryService_Path_Create = "/";
	public static final String CategoryService_Path_Find = "/";

	/**
	 * customer service related
	 */
	public static final String CustomerService_Name = "customers";
	public static final String CustomerService_Version = "v1";
	public static final String CustomerService_Path = "/" + ApiLabel + "/" + CustomerService_Name + "/"
			+ CustomerService_Version;

	public static final String CustomerService_Path_Login = "/login";

	/**
	 * product type service related
	 */
	public static final String ProductTypeService_Name = "product-types";
	public static final String ProductTypeService_Version = "v1";
	public static final String ProductTypeService_Path = "/" + ApiLabel + "/" + ProductTypeService_Name + "/"
			+ ProductTypeService_Version;

	public static final String ProductTypeService_Path_Create = "/";
	public static final String ProductTypeService_Path_Find = "/";

}
