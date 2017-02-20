package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.service.PersonService;

@RestController
@RequestMapping(value="/restful/person")
public class PersonController {
	@Autowired
	PersonService personService;

	@RequestMapping(method=RequestMethod.POST)
	public String addPerson(Person person){
		this.personService.addPerson(person);
		return "OK";
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public String updatePerson(Person person){
		return this.personService.updatePerson(person);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> retrievePersonAll(){
		return this.personService.retrivePersionAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Person getPerson(@PathVariable String id){
		return this.personService.getPersion(id);
	}
}
