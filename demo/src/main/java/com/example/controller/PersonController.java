package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.service.PersonService;

// curl -X POST localhost:8888/restful/person -H "data: json" -H "Content-Type: application/json" -d "{\"id\":\"vssp000\", \"age\":15}"
// curl -X PUT localhost:8888/restful/person -H "data: json" -H "Content-Type: application/json" -d "{\"oid\":12,\"id\":\"vssp000\", \"description\": \"My Test\", \"age\":30}"

@RestController
@RequestMapping(value="/restful/person")
public class PersonController {
	@Autowired
	PersonService personService;

	@RequestMapping(method=RequestMethod.POST)
	public String addPerson(@RequestBody Person person){
		return this.personService.addPerson(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public String updatePerson(@RequestBody Person person){
		return this.personService.updatePerson(person);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> retrievePersonAll(){
		return this.personService.retrivePersonAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Person getPerson(@PathVariable String id){
		return this.personService.getPersion(id);
	}
	
	@RequestMapping(value="/find/{name}", method=RequestMethod.GET)
	public List<Person> retrievePerson(@PathVariable String name){
		return this.personService.retrivePerson(name);
	}
}
