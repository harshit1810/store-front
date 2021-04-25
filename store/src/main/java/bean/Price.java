/**
 * 
 */
package bean;

import java.util.Date;

/**
 * @author hsriv
 *
 */
public class Price extends BaseEntity {

	/**
	 * 
	 */
	public Price() {
		// TODO Auto-generated constructor stub
	}

	private Date validFrom;
	private Date validTo;
	private float amount;
	private float discountedPrice;
	private String discountId;

}
