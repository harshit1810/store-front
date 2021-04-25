/**
 * 
 */
package bean;

/**
 * @author hsriv
 *
 */
public class Product extends BaseEntity {

	/**
	 * 
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}

	private String name;
	private String description;
	private String slug;
	private boolean published;
	private String[] keywords;
	private String productType; // id of product type
	private String[] categories; // ids of categories
	private ProductVariant[] variants;
}
