package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")  //name of my table is category
public class SweetsList
{
	@Id								//primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="kajuProducts")
	private String sweetCatgoryKaaju;
	
	@Column(name="MilkProducts")
	private String sweetCategoryMilk;
	
	@Column(name="GheeProducts")
	private String sweetCategoryGhee;

	//parameritized constructor
	public SweetsList(long id,String sweetCatgoryKaaju, String sweetCategoryMilk, String sweetCtegoryGhee) {
		super();
		this.id=id;
		this.sweetCatgoryKaaju = sweetCatgoryKaaju;
		this.sweetCategoryMilk = sweetCategoryMilk;
		this.sweetCategoryGhee = sweetCtegoryGhee;
		
	}
	public SweetsList()//default constructor
	{
		
	}
	
	//getters and setters
	public String getSweetCatgoryKaaju() {
		return sweetCatgoryKaaju;
	}

	public void setSweetCatgoryKaaju(String sweetCatgoryKaaju) {
		this.sweetCatgoryKaaju = sweetCatgoryKaaju;
	}

	public String getSweetCategoryMilk() {
		return sweetCategoryMilk;
	}

	public void setSweetCategoryMilk(String sweetCategoryMilk) {
		this.sweetCategoryMilk = sweetCategoryMilk;
	}

	public String getSweetCtegoryGhee() {
		return sweetCategoryGhee;
	}

	public void setSweetCtegoryGhee(String sweetCtegoryGhee) {
		this.sweetCategoryGhee = sweetCtegoryGhee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
