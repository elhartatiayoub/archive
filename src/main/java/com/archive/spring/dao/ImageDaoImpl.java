/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.archive.spring.dao;


import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Iob
 */

@Repository
public class ImageDaoImpl implements ImageDao{
    
        private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        
        //exemple
        
//        @Override
//        public void addUser(User u) {
//                Session session = this.sessionFactory.getCurrentSession();
//		session.persist(u);
//		logger.info("Person saved successfully, Person Details="+u);
//        }
    
}
