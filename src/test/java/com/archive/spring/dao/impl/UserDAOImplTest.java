/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring.dao.impl;

import com.archive.spring.dao.UserDAO;
import com.archive.spring.model.User;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Iob
 */
public class UserDAOImplTest {
    
    final org.slf4j.Logger logger = LoggerFactory.getLogger(SessionFactory.class);

    @Autowired
    private SessionFactory sessionFactory;
    
    private UserDAO userDAO = null;
    
    public UserDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        userDAO = new UserDAOImpl();
    }
    
    @After
    public void tearDown() {
        userDAO = null;
        sessionFactory.close();
    }



    /**
     * Test of addUser method, of class UserDAOImpl.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User u = new User();
        u.setEmail("aaaaa.aa@aa.com");
        u.setName("iob");
        
        
        UserDAOImpl instance = new UserDAOImpl();
        instance.addUser(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserDAOImpl.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User p = null;
        UserDAOImpl instance = new UserDAOImpl();
        instance.updateUser(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserDAOImpl.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String email = "";
        String pass = "";
        UserDAOImpl instance = new UserDAOImpl();
        User expResult = null;
        User result = instance.getUser(email, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByName method, of class UserDAOImpl.
     */
    @Test
    public void testGetUserByName() {
        System.out.println("getUserByName");
        String name = "";
        UserDAOImpl instance = new UserDAOImpl();
        List<User> expResult = null;
        List<User> result = instance.getUserByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class UserDAOImpl.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        int id = 0;
        UserDAOImpl instance = new UserDAOImpl();
        instance.removeUser(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class UserDAOImpl.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UserDAOImpl instance = new UserDAOImpl();
        List<User> expResult = null;
        List<User> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
