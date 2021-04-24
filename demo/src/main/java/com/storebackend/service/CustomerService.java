package com.storebackend.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.storebackend.common.bean.Customer;
import com.storebackend.common.jpa.CustomerJPA;

@Service
public class CustomerService implements UserDetailsService {

	Logger log = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	CustomerJPA custJPA;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("inside loadUserByUsername");
		List<Customer> customerList = custJPA.findByUsername(username);
		if (customerList.isEmpty()) {
			log.info("User Not found");
			return null;
		} else {
			Customer custOb = customerList.get(0);
			log.info("User found: {}", custOb.getUsername());
			return new User(custOb.getUsername(), custOb.getPassword(), new ArrayList<>());
		}
	}

}
