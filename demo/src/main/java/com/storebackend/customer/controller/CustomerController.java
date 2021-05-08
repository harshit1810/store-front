/**
 * 
 */
package com.storebackend.customer.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.storebackend.common.jpa.CustomerJPA;
import com.storebackend.common.util.CommonConstants;
import com.storebackend.customer.util.CustomerConstants;

/**
 * @author hsriv
 *
 */
@RestController
@RequestMapping(value = "/" + CommonConstants.ApiLabel + "/" + CustomerConstants.ApiVersion + "/customers")
public class CustomerController {

	@Autowired
	CustomerJPA customer;

	/**
	 * @return the customer
	 */
	public CustomerJPA getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(CustomerJPA customer) {
		this.customer = customer;
	}

	@PostMapping(value = "/login", produces = "text/plain", consumes = "application/json")
	public ResponseEntity<String> login(@RequestBody Login creds) {
		Calendar calendar = Calendar.getInstance();

		try {
			Algorithm algorithm = Algorithm.HMAC256("secret");
			// set exipry to 6 hours
			calendar.setTimeInMillis(calendar.getTimeInMillis() + (6 * 60 * 60 * 1000));

			String token = JWT.create().withExpiresAt(calendar.getTime()).withIssuer("auth0").sign(algorithm);
			System.out.println("Generated token for " + creds.getEmail());
			return new ResponseEntity<String>(token, HttpStatus.OK);
		} catch (JWTCreationException exception) {
			// Invalid Signing configuration / Couldn't convert Claims.
			System.out.println("Failed to sign token for user " + creds.getEmail());
			return new ResponseEntity<String>("Failed to login", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

class Login {
	private String email;
	private String password;

	/**
	 * 
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}

}
