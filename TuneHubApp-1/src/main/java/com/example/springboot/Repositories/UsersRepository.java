package com.example.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email) ;
		
	
	

}
