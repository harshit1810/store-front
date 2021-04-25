package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Product;
import utils.Constants;

@Controller
@RequestMapping(value = "/" + Constants.ApiLabel + "/" + Constants.ApiVersion + "/products")
public class ProductController {

	@GetMapping(value = "/${productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getById(@PathVariable String productId) {
		return ResponseEntity.ok(new Product());
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> find() {
		return ResponseEntity.ok(new ArrayList<Product>() {
			/**
			* 
			*/
			private static final long serialVersionUID = -3705531735089209113L;

			{
				add(new Product());
				add(new Product());
				add(new Product());
			}
		});
	}

}
