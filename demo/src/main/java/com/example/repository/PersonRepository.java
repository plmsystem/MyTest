package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.entity.Person;

@RepositoryRestResource(collectionResourceRel="person", path="person")
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@RestResource(path="id", rel="person", exported=true)
	public Person findById(String id);

	@RestResource(path="name")
	public List<Person> findByNameLike(String name);
	
}
