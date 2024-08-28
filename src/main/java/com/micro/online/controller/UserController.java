package com.micro.online.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.micro.online.model.User;
import com.micro.online.service.UserService;
 

 
@RestController

@CrossOrigin("*")

@RequestMapping("/user")

public class UserController {
 
	@Autowired

	UserService userservice;
 
	

	@PostMapping("/doUserInsert")

	public User insertUser(@RequestBody User newUser) {

		return userservice.insertUser(newUser);
 
	}
//	@PostMapping("/login")
//	public User login(@RequestBody User user) {
//		return userservice.userLogin(user.getUserName(), user.getUserPassword());
//	}
// 
	@PutMapping("/updateUser")

	public User updateUser(@RequestBody User user) {
 
		return userservice.updateUser(user);

	}
 
	

	@GetMapping("/getAllUserList")

	public List<User> getUsers() {

		return userservice.getUsers();

	}
 
	

	@GetMapping("/GetByUserId/{userId}")

	public User find(@PathVariable("userId") int userId) {

		return userservice.userfind(userId);

	}
 
	@GetMapping("/loginUser/{userName}/{userPassword}")

	public  User  loginUser(@PathVariable("userName") String userName,

			@PathVariable("userPassword") String userPassword) {
 
		User existingUser = userservice.findByuserName(userName);
		try {
			if (existingUser != null && userPassword.equals(existingUser.getUserPassword())) {
				return existingUser;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
 
	}
	
	}
	
	
	
	
	
	
	
	
	

//	@GetMapping("/GetByUserId/{userId}")
//
//	public User find(@PathVariable("userId") int userId) {
//
//		return userservice.userfind(userId);
//
//	


 

 