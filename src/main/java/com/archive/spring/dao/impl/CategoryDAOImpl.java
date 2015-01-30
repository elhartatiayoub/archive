/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring.dao.impl;

import com.archive.spring.dao.CategoryDAO;
import com.archive.spring.model.Category;
import java.util.List;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Iob
 */
public class CategoryDAOImpl implements CategoryDAO{
    
    private static final Logger logger = LoggerFactory.getLogger(ImageDAOImpl.class);
    
    @Autowired
    @Qualifier(value = "sessionFactory")
    SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

    @Override
    public List<Category> getAllCategiries() {
        List<Category> cats = null;
        
        return cats;
    }

    @Override
    public Category getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
