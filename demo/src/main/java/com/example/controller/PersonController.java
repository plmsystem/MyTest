package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;

	@RequestMapping("/AddPerson")
	public String addPerson(Person person){
		this.personService.addPerson(person);
		return "OK";
	}
	
	@RequestMapping("/RetrievePerson")
	public List<Person> retrievePerson(){
		return this.personService.retrivePersion();
	}
	
	@RequestMapping("/GetPerson")
	public Person getPerson(@RequestParam String id){
		return this.personService.getPersion(id);
	}
}
