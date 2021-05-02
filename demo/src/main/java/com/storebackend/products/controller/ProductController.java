/**
 * 
 */
package com.storebackend.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storebackend.common.util.CommonConstants;
import com.storebackend.products.util.ProductsConstants;

/**
 * @author hsriv
 *
 */
@RestController
@RequestMapping(value = "/" + CommonConstants.ApiLabel + "/" + ProductsConstants.ApiVersion + "/products")
public class ProductController {

	@GetMapping(value = "/greet", produces = "text/plain")
	public String home() {
		return "Hello world!";
	}
}
