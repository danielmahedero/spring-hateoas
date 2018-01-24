package com.concretepage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="dress")
public class Dress {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="dress_category_id")
	@JsonBackReference
	private DressCategory category;

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

	public DressCategory getCategory() {
		return category;
	}

	public void setCategory(DressCategory category) {
		this.category = category;
	}

	public Dress(String name, DressCategory category) {
		this.name = name;
		this.category = category;
	}
	
	public Dress(){
		
	}
	
	

}
