/**
 * 
 */
package com.storebackend.category.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storebackend.category.util.CategoriesConstants;
import com.storebackend.common.bean.Category;
import com.storebackend.common.jpa.CategoryJPA;
import com.storebackend.common.util.CommonConstants;

/**
 * @author hsriv
 *
 */
@RestController
@RequestMapping(value = "/" + CommonConstants.ApiLabel + "/" + CategoriesConstants.ApiVersion + "/categories")
public class CategoryController {

	@Autowired
	CategoryJPA categoryJpa;

	/**
	 * @return the categoryJpa
	 */
	public CategoryJPA getCategoryJpa() {
		return categoryJpa;
	}

	/**
	 * @param categoryJpa the categoryJpa to set
	 */
	public void setCategoryJpa(CategoryJPA categoryJpa) {
		this.categoryJpa = categoryJpa;
	}

	@GetMapping(value = "/", produces = "application/json")
	public List<Category> find() {
		return categoryJpa.findAll();
	}

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Integer> create(@RequestBody Category draft) {
		draft.setCreatedAt(new Date());
		draft.setCreatedBy(0L);
		draft.setVersion(1);
		categoryJpa.save(draft);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
}
