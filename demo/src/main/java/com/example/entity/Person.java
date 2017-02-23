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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Person {
	
	public enum GENDER {MALE, FEMALE}; 
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	long oid;

	@Column(unique=true, updatable=false)
	String id;

	@JsonIgnore
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
	@Column(name="CREATIED_DATE", updatable=false)
	Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFIED_DATE")
	Date modifiedDate;
	
	@PrePersist
	void onCreate() {
		Date date = new Date();
		this.createdDate = date;
		this.modifiedDate = date;
	}

	@PreUpdate
	void onPersist() {
		this.modifiedDate = new Date();
	}
}
