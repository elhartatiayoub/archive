package com.archive.spring.dao.impl;

import com.archive.spring.dao.UserDAO;
import com.archive.spring.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addUser(User u) {
        Transaction t = null;
        try {
            Session session = this.sessionFactory.getCurrentSession();
            t = session.beginTransaction();
            session.persist(u);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
    }

    @Override
    public void updateUser(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Person updated successfully, Person Details=" + p);
    }

    @Override
    public User getUser(String email, String pass) {
        String hql = "FROM User E WHERE E.email = :email";
        Query query = sessionFactory.openSession().createQuery(hql);

        query.setParameter("email", email);
        List results = query.list();
        if (results.isEmpty()) {
            return null;
        } else {
            return (User) results.get(0);
        }
    }

    @Override
    public List<User> getUserByName(String name) {
        String hql = "FROM User E WHERE E.name = :name";
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setParameter("name", name);
        List results = query.list();
        return results;
    }

    @Override
    public void removeUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUsers() {
        Transaction t = null;
        try {
            Session session = this.sessionFactory.getCurrentSession();
            t = session.beginTransaction();
            List<User> personsList = session.createQuery("from User").list();
            t.commit();
            return personsList;
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
    }

}
