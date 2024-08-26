package com.micro.online.repository;

import java.util.List;


import com.micro.online.model.User;
public interface UserRepo {
 
		public User insertUser(User newUser);
 
		public User updateUser(User user);
 
		public List<User> getUsers();
 
		public User userfind(int userId);
		
		public User findUserByUserEmail(String userEmail);
 
		public List<Integer> getUserIdlist();
 
		public List<User> searchUser(String userName);
 
		public User userLogin(String userName, String userPassword);
		public User findByuserName(String userName);
	}

