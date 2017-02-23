package com.example.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entity.Person;

@RepositoryRestResource
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	
	public Person findById(@Param(value="id") String id);

	public List<Person> findByNameLike(@Param(value="name") String name);
	
}
