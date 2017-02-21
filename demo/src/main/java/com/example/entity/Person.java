package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {
	
	public enum GENDER {MALE, FEMALE}; 
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	long oid;

	@Column(unique=true)
	String id;

	@Column(length=100) 
	String pass;
	
	@Column
	String name;
	
	@Column(length=4000) 
	String description;
	
	@Column(length=10) 
	@Enumerated(EnumType.STRING)
	GENDER gender;
	
	@Column 
	int age;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATIED_DATE")
	Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFIED_DATE")
	Date modifiedDate;
	
	@PrePersist
	void onCreate() {
		Date date = new Date();
		this.setCreatedDate(date);
		this.setModifiedDate(date);
	}

	@PreUpdate
	void onPersist() {
		this.setModifiedDate(new Date());
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	private void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	private void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid){
		this.oid = oid;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
