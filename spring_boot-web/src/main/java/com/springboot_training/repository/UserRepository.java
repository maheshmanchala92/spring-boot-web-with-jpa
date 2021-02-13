package com.springboot_training.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot_training.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

	@Modifying
	@Transactional
	@Query("update User u set u.firstName = :firstName, " 
			+ " u.lastName= :lastName, " 
			+ " u.age = :age, "
			+ " u.gender = :gender " 
			+ " where u.userId = :userId")
	public void updateUser(@Param("firstName") String firstName, 
			@Param("lastName") String lastName,
			@Param("age") Integer age, 
			@Param("gender") String gender, 
			@Param("userId") Integer userId);
}
