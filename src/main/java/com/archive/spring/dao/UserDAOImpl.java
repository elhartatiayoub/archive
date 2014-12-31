package com.archive.spring.dao;

import com.archive.spring.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

    @Override
    public void addUser(User u) {
                Session session = this.sessionFactory.getCurrentSession();
                System.out.println(u);
		session.persist(u);
		logger.info("Person saved successfully, Person Details="+u);    }

    @Override
    public void updateUser(User p) {
                Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
    }

  

    @Override
    public User getUser(String email, String pass) {
                String hql = "FROM User E WHERE E.email = :email";
                Query query = sessionFactory.openSession().createQuery(hql);
                
                query.setParameter("email",email);
                List results = query.list();
                if(results.isEmpty())
                    return null;
                else
		return (User) results.get(0);
    }

    @Override
    public List<User> getUserByName(String name) {
                String hql = "FROM User E WHERE E.name = :name";
                Query query = sessionFactory.openSession().createQuery(hql);
                query.setParameter("name",name);
                List results = query.list();
		return results;
    }

    @Override
    public void removeUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<User> getAllUsers(){
        Session session = this.sessionFactory.getCurrentSession();
        List<User> personsList = session.createQuery("from User").list();
        
        return personsList;
    }

}
