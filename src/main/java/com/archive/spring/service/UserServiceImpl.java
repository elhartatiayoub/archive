package com.archive.spring.service;

import com.archive.spring.dao.RoleDAO;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.archive.spring.dao.UserDAO;
import com.archive.spring.model.Role;
import com.archive.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired  
    private UserDAO userDAO;
    
    @Autowired
    private RoleDAO roleDAO;

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    
    
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User p) {
        Role r = roleDAO.getRoleByName("user");
        p.setRole(r);
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
