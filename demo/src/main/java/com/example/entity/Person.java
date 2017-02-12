package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Person {
	
	public enum GENDER {MALE, FEMALE}; 

	@Id 
	String id;
	
	@Column(length=100) 
	String pass;
	
	@Column(length=4000) 
	String description;
	
	@Column(length=10) 
	@Enumerated(EnumType.STRING)
	GENDER gender;
	
	@Column 
	int age;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
