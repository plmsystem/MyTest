package com.example.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	
	public Person findById(String id);

	public List<Person> findByNameLike(String name);
	
}
