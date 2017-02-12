package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Person;
import com.example.repository.PersonRepository;

@Service
@Transactional
public class PersonSeviceImpl implements PersonService {
	@Autowired
	PersonRepository personRepository;

	@Override
	public void addPerson(Person person) {
		this.personRepository.save(person);
	}

	@Override
	public List<Person> retrivePersion() {
		return this.personRepository.findAll();
	}

	@Override
	public Person getPersion(String id) {
		return this.personRepository.findOne(id);
	}

}
