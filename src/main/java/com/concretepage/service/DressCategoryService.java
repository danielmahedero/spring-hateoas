package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.DressCategory;
import com.concretepage.repository.DressCategoryRepository;

@Service
public class DressCategoryService implements IDressCategoryService{

	@Autowired
	private DressCategoryRepository dressCategoryRepository;
	
	@Override
	public List<DressCategory> getAllDressCategories(){
		return dressCategoryRepository.findAll();
	}
	
	
}
