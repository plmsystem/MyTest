package com.example.service;

import java.util.ArrayList;
import java.util.Iterator;
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
	public String addPerson(Person person) {
		if (this.personRepository.findById(person.getId()) != null){
			return person.getId() + " already exists.";
		}
		
		this.personRepository.save(person);
		return "OK";
	}
	
	@Override
	public String updatePerson(Person person) {
		if (!this.personRepository.exists(person.getOid())){
			return person.getId() + " does not exists.";
		}
		
		this.personRepository.save(person);
		return "OK";
	}

	@Override
	public Person getPersion(String id) {
		return this.personRepository.findById(id);
	}

	@Override
	public String deletePerson(Person person) {
		if (!this.personRepository.exists(person.getOid())){
			return person.getId() + " does not exists.";
		}
		
		this.personRepository.delete(person);
		return "OK";
	}

	@Override
	public List<Person> retrivePersonAll() {
		Iterable<Person> it = this.personRepository.findAll();
		Iterator<Person> i = it.iterator();
		List<Person> listPerson = new ArrayList<Person>();
		while(i.hasNext()) listPerson.add(i.next());
		
		return listPerson;
	}

	@Override
	public List<Person> retrivePerson(String name) {
		name += "%";
		return this.personRepository.findByNameLike(name);
	}

}
