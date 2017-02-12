package com.example.service;

import java.util.List;

import com.example.entity.Person;

public interface PersonService {

	public void addPerson(Person person);
	
	public List<Person> retrivePersion();
	
	public Person getPersion(String id);
}
