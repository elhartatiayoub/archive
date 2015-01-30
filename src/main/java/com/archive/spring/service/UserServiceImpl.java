package com.archive.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.archive.spring.dao.UserDAO;
import com.archive.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDAO")
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User p) {
        this.userDAO.addUser(p);
    }

    @Override
    @Transactional
    public void updateUser(User p) {
        this.userDAO.updateUser(p);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return this.userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public User getUser(String email, String pass) {

        return this.userDAO.getUser(email, pass);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDAO.removeUser(id);
    }

}
