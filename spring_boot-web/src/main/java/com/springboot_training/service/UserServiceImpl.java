package com.springboot_training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot_training.model.User;
import com.springboot_training.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		//select * from user
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(Integer userId) {
		//select * from user where userId = 3;
		Optional<User> op = userRepository.findById(userId);
		if(op.isPresent()) {
			return op.get();
		}
//		throw new RuntimeException("user not found with userId = " + userId);
		return null;
	}

	@Override
	public User updateUser(User user) {
		userRepository.updateUser(user.getFirstName(),
				user.getLastName(), 
				user.getAge(), 
				user.getGender(),
				user.getUserId());
		return getUser(user.getUserId());
	}
	
	@Override
	public User deleteUser(Integer userId) {
		User user = getUser(userId);
		userRepository.deleteById(userId);
		return user;
	}
}
