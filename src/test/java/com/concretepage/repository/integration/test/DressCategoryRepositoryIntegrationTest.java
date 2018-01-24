package com.concretepage.repository.integration.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.concretepage.entity.Dress;
import com.concretepage.entity.DressCategory;
import com.concretepage.repository.DressCategoryRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DressCategoryRepositoryIntegrationTest {
	
	@Autowired
	private DressCategoryRepository dressCategoryRepository;
	
	@Test
	public void testSave(){
		
		List<DressCategory> listDressCategory = dressCategoryRepository.findAll();
		int size = listDressCategory.size();
		
		DressCategory categoryA = new DressCategory("Short Dress");
		
		Set<Dress> dressesA = new HashSet<Dress>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			{
				add(new Dress("Dress a1", categoryA));
				add(new Dress("Dress a2", categoryA));
				add(new Dress("Dress a3", categoryA));
			}
		};
		
		categoryA.setDresses(dressesA);
		
		DressCategory categoryB = new DressCategory("Long Dress");
		Set<Dress> dressedB = new HashSet<Dress>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			{
				add(new Dress("Dress b1", categoryB));
				add(new Dress("Dress b2", categoryB));
				add(new Dress("Dress b3", categoryB));
			}
		};
		
		categoryB.setDresses(dressedB);
		
		dressCategoryRepository.save(new HashSet<DressCategory>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			{
				add(categoryA);
				add(categoryB);
			}
		});
		
		listDressCategory = dressCategoryRepository.findAll();
		assertTrue(listDressCategory.size() == 2 + size);
	}
	

}
