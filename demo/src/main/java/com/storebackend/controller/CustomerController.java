/**
 * 
 */
package com.storebackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storebackend.common.bean.JWTResponse;
import com.storebackend.common.util.CommonConstants;
import com.storebackend.helper.JwtUtil;
import com.storebackend.service.CustomerService;

/**
 * @author hsriv
 *
 */
@RestController
@RequestMapping(value = CommonConstants.CustomerService_Path)
public class CustomerController {

	Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping(value = CommonConstants.CustomerService_Path_Login, consumes = "application/json")
	public ResponseEntity<?> generateSecurityToken(@RequestBody Login login) throws Exception {
		try {
			this.authManager
					.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
		} catch (BadCredentialsException un) {
			un.printStackTrace();
			throw new Exception("incorrect details!");
		}
		UserDetails userDetails = this.customerService.loadUserByUsername(login.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JWTResponse(token));
	}

}

class Login {
	private String username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}