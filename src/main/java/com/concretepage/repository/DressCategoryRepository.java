package com.concretepage.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.concretepage.entity.DressCategory;

@Repository
public interface DressCategoryRepository extends JpaRepository<DressCategory, Integer>{

	@Query("select dc from DressCategory dc where dc.name = :name")
	List<DressCategory> findByName(@Param("name") String name);
}
