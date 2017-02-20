package com.example.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.DemoApplication;
import com.example.entity.Person;
import com.example.entity.Person.GENDER;

@RunWith(SpringJUnit4ClassRunner.class)	
@SpringBootTest(classes=DemoApplication.class)
@WebAppConfiguration
@Transactional
@Rollback(true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonServiceTest {
	@Autowired
	PersonService personService;
	
	@Test
	public void addPerson(){
		List<Person> list = personService.retrivePersionAll();
		for (Person p : list){
			personService.deletePerson(p);
		}
		
		Person p = new Person();
		p.setId("vssp770");
		p.setAge(39);
		p.setDescription("이병조");
		p.setGender(GENDER.MALE);
		
		String result = personService.addPerson(p);
		assertEquals(result, "OK");
		
		p = new Person();
		p.setId("jh.nam");
		p.setAge(34);
		p.setDescription("남지희");
		p.setGender(GENDER.FEMALE);
		
		result = personService.addPerson(p);
		assertEquals(result, "OK");
	}
	
	@Test
	public void updatePerson(){
		String id = "vssp770";
		
		Person person = personService.getPersion(id);
		person.setPass("1234");
		String result = personService.updatePerson(person);
		Person person2 = personService.getPersion(id);
		
		assertEquals(result, "OK");
		assertEquals(person.getPass(), person2.getPass());
	}
	
	@Test
	public void retrievePersion(){
		List<Person> list = personService.retrivePersionAll();
		assertEquals(list.isEmpty(), false);
	}
	
	@Test
	public void getPerson(){
		String id = "vssp770";
		
		Person person = personService.getPersion(id);
		assertEquals(person.getId(), id);
	}
}
