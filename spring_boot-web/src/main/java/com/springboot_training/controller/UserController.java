package com.springboot_training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_training.model.User;
import com.springboot_training.service.UserService;

@RestController
@RequestMapping("/spring-boot-training")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users") 
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/user/{userId}") 
	public User getUser(@PathVariable("userId") Integer userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PutMapping(value = "/user")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping(value = "/user/{userId}")
	public User deleteUser(@PathVariable("userId") Integer userId) {
		return userService.deleteUser(userId);
	}
}
