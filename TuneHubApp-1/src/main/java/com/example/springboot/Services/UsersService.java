package com.example.springboot.Services;

import com.example.springboot.entities.User;

public interface UsersService {
	public String addUser(User user);
	public boolean emailExist(String email);
	public Boolean validateUser(String email,String password);
	public String getRole(String email);
	public User getUser(String email);
	public void updateUser(User user);

}
