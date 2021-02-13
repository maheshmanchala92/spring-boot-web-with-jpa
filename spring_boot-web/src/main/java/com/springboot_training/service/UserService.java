package com.springboot_training.service;

import java.util.List;

import com.springboot_training.model.User;

public interface UserService {
	
	public abstract List<User> getUsers();
	
	public abstract User saveUser(User user);

	public abstract User getUser(Integer userId);

	public abstract User updateUser(User user);
	
	public abstract User deleteUser(Integer userId);

}
