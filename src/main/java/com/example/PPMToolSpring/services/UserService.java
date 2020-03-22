package com.example.PPMToolSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.PPMToolSpring.domain.User;
import com.example.PPMToolSpring.exceptions.UsernameAlreadyExistsException;
import com.example.PPMToolSpring.repositories.UserRepository;

@Service 
public class UserService {

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User saveUser (User newUser ) {
		try {
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			newUser.setUsername(newUser.getUsername());
			
			newUser.setConfirmPassword("");
			return userRepository.save(newUser );
			
		}catch(Exception e ) {
			throw new UsernameAlreadyExistsException ("Username: "+newUser.getUsername()+" already exists");
		}
		
	}
	

}
