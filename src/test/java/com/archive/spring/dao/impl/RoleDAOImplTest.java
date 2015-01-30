/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring.dao.impl;

import com.archive.spring.dao.RoleDAO;
import com.archive.spring.model.Role;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Iob
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/appServlet/servlet-context.xml")
public class RoleDAOImplTest {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    RoleDAO roleDao;

    public RoleDAOImplTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of getRoleByID method, of class RoleDAOImpl.
     */
    @Test
    public void testGetRoleByID() {
        System.out.println("getRoleByID");
        int id = 1;
        Role expResult = new Role();
        expResult.setName("admin");
        Role result = roleDao.getRoleByID(id);
        assertEquals(expResult.getName(), result.getName());

    }

    /**
     * Test of getRoleByName method, of class RoleDAOImpl.
     */
    @Test
    public void testGetRoleByName() {
        System.out.println("getRoleByName");
        String name = "admin";

        Role result = roleDao.getRoleByName(name);
        assertEquals(1, result.getID());

    }

    /**
     * Test of addRole method, of class RoleDAOImpl.
     */
    @Test
    public void testAddRole() {
        System.out.println("addRole");
        Role role = new Role();
        role.setName("test");
        boolean expResult = true;
        boolean result = roleDao.addRole(role);
        assertEquals(expResult, result);

    }

}
