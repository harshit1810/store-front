/**
 * 
 */
package com.storebackend.common.bean;

/**
 * @author hsriv
 *
 */
public class Attribute extends BaseEntity {

	/**
	 * 
	 */
	public Attribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param value
	 */
	public Attribute(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}

	private String name;
	private Object value;

}
