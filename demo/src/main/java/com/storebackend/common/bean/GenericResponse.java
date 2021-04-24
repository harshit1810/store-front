/**
 * 
 */
package com.storebackend.common.bean;

/**
 * @author hsriv
 *
 */
public class GenericResponse {

	private String message;
	private int code;
	private String status;
	private String errorCode;

	/**
	 * 
	 */
	public GenericResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param code
	 * @param status
	 */
	public GenericResponse(String message, int code, String status) {
		super();
		this.message = message;
		this.code = code;
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GenericResponse [message=" + message + ", code=" + code + ", status=" + status + "]";
	}

}
