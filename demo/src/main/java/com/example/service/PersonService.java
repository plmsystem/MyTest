package com.example.service;

import java.util.List;

import com.example.entity.Person;

public interface PersonService {

	public void addPerson(Person person);
	
	public String updatePerson(Person person);
	
	public List<Person> retrivePersionAll();
	
	public Person getPersion(String id);
}
