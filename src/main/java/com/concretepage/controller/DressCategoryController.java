package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concretepage.entity.DressCategory;
import com.concretepage.service.IDressCategoryService;

@Controller
@RequestMapping("dress")
public class DressCategoryController {
	
	@Autowired
	IDressCategoryService dressCategoryService;
	
	//  http://localhost:8080/dress/category
	@GetMapping("category")
	public ResponseEntity<List<DressCategory>> getAllDressCategories(){
		List<DressCategory> list = dressCategoryService.getAllDressCategories();
		return new ResponseEntity<List<DressCategory>>(list, HttpStatus.OK);
	}
	
}
