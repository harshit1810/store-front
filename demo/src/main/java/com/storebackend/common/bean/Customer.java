/**
 * 
 */
package com.storebackend.common.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author hsriv
 *
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_id_sequence_gen")
	@SequenceGenerator(name = "cust_id_sequence_gen", sequenceName = "customers_id_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column
	private int version;

	@Column
	private String key;

	@Column
	private String email;

	@Column
	private long phone;

	@Column(name = "customer_number")
	private String customerNumber;

	@Column(name = "dob")
	private Date dateOfBirth;

	@Column
	private String gender;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	@Column
	private String salutation;

	@Column(name = "email_verified")
	private boolean isEmailVerified;

	@Column(name = "phone_verified")
	private boolean isPhoneVerified;

	@Column
	private Long group;

	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param version
	 * @param key
	 * @param email
	 * @param phone
	 * @param customerNumber
	 * @param dateOfBirth
	 * @param gender
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param salutation
	 * @param isEmailVerified
	 * @param isPhoneVerified
	 * @param group
	 */
	public Customer(Long id, int version, String key, String email, long phone, String customerNumber, Date dateOfBirth,
			String gender, String firstName, String lastName, String middleName, String salutation,
			boolean isEmailVerified, boolean isPhoneVerified, Long group) {
		super();
		this.id = id;
		this.version = version;
		this.key = key;
		this.email = email;
		this.phone = phone;
		this.customerNumber = customerNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.salutation = salutation;
		this.isEmailVerified = isEmailVerified;
		this.isPhoneVerified = isPhoneVerified;
		this.group = group;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public long getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}

	/**
	 * @return the customerNumber
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the isEmailVerified
	 */
	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	/**
	 * @param isEmailVerified the isEmailVerified to set
	 */
	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	/**
	 * @return the isPhoneVerified
	 */
	public boolean isPhoneVerified() {
		return isPhoneVerified;
	}

	/**
	 * @param isPhoneVerified the isPhoneVerified to set
	 */
	public void setPhoneVerified(boolean isPhoneVerified) {
		this.isPhoneVerified = isPhoneVerified;
	}

	/**
	 * @return the group
	 */
	public Long getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Long group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", version=" + version + ", key=" + key + ", email=" + email + ", phone=" + phone
				+ ", customerNumber=" + customerNumber + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", salutation="
				+ salutation + ", isEmailVerified=" + isEmailVerified + ", isPhoneVerified=" + isPhoneVerified
				+ ", group=" + group + "]";
	}

}
