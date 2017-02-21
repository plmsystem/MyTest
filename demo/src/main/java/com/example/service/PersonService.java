package com.example.service;

import java.util.List;

import com.example.entity.Person;

public interface PersonService {

	public String addPerson(Person person);
	
	public String updatePerson(Person person);
	
	public String deletePerson(Person person);
	
	public Person getPersion(String id);
	
	public List<Person> retrivePersonAll();
	
	public List<Person> retrivePerson(String name);
	
}
