package com.example.springboot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entities.User;
import com.example.springboot.Repositories.*;

@Service
public class UsersServiceImplementation implements UsersService {
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(User user) {
		repo.save(user);
		return "User created and saved ";
	}

	@Override
	public boolean emailExist(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
			
		}
		else {
			return true;
		}
		
	}

	@Override
	public Boolean validateUser(String email, String password) {
		
		String db_password=repo.findByEmail(email).getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		String role=repo.findByEmail(email).getRole();
		return role;
		
	}

	@Override
	public User getUser(String email) {
		return repo.findByEmail(email);
		
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}

	
	
	

}
