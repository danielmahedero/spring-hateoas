package com.concretepage.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="dress_category")
public class DressCategory {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	@JsonManagedReference
	private Set<Dress> dresses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Dress> getDresses() {
		return dresses;
	}

	public void setDresses(Set<Dress> dresses) {
		this.dresses = dresses;
	}

	public DressCategory(String name) {
		this.name = name;
	}

	public DressCategory(){
		
	}
}
