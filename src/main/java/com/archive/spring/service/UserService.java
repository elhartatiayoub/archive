package com.archive.spring.service;

import java.util.List;

import com.archive.spring.model.User;

public interface UserService {

	public void addUser(User p);
	public void updateUser(User p);
	public List<User> listUser();
	public User getUserById(int id);
        public User getUser(String email, String pass);
	public void removeUser(int id);
	
}
