/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring.dao.impl;

import com.archive.spring.dao.ImageDao;
import com.archive.spring.model.Image;
import com.archive.spring.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Iob
 */
@Repository("imageDAO")
public class ImageDAOImpl implements ImageDao {

    private static final Logger logger = LoggerFactory.getLogger(ImageDAOImpl.class);

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addImage(Image img) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        session.persist(img);
        t.commit();
        logger.info("Image added successfully");
    }

    @Override
    public void updateImage(Image img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getImageById(int id) {
        String hql = "FROM Image I WHERE I.id=:id";
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=null;
        try {
            Query query = session.createQuery(hql);
            transaction=session.beginTransaction();
            query.setParameter("ID ", id);
            List results = query.list();
            transaction.commit();
            if (results.isEmpty()) {
                return null;
            } else {
                return (Image) results.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
             return null;
        }
       
    }

    @Override
    public List<Image> getAllImages() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        List<Image> imgList = session.createQuery("from Image").list();
        tr.commit();
        return imgList;
    }

    @Override
    public void removeImage(int id) {
    }
      
    public List<Image> getLikedImages() {
        List<Image> liste = new ArrayList<Image>();
        Session session = this.sessionFactory.getCurrentSession();
            Query query = session.createQuery("FROM Image img ORDER BY img.likes asc");
            query.setMaxResults(100);
            liste = query.list();
       
        return liste;
    }
      public List<Image> getDownloadedImages() {
        List<Image> liste = new ArrayList<Image>();
        Session session = this.sessionFactory.getCurrentSession();
            Query query = session.createQuery("FROM Image img ORDER BY img.downloads asc");
            query.setMaxResults(100);
            liste = query.list();
       
        return liste;
    }

}
