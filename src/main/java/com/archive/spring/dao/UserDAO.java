package com.archive.spring.dao;

import java.util.List;

import com.archive.spring.model.User;

public interface UserDAO {

	public void addUser(User p);
	public void updateUser(User p);
        public List<User> getUserByName(String name);
        public List<User> getAllUsers();
	public User getUser(String email, String pass);
	public void removeUser(int id);
}
