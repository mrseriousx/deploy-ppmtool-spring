package com.example.PPMToolSpring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.PPMToolSpring.domain.Backlog;

@Repository  
public interface BacklogRepository extends CrudRepository<Backlog,Long > {
	
	Backlog findByProjectIdentifier(String Identifier );
}
