package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	public Person findById(String id);
	
	public List<Person> findByNameLike(String name);
	
}
