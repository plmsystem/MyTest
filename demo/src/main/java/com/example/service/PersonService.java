package com.example.service;

import java.util.List;

import com.example.entity.Person;

public interface PersonService {

	public String addPerson(Person person);
	
	public String updatePerson(Person person);
	
	public List<Person> retrivePersionAll();
	
	public Person getPersion(String id);
	
	public String deletePerson(Person person);
}
