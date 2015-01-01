/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.archive.spring.service;

import com.archive.spring.dao.ImageDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Iob
 */

@Service
public class ImageServiceImpl implements ImageService{
    
    private ImageDao imageDao;

    public void setImageDao(ImageDao imageDao) {
        this.imageDao = imageDao;
    }
    
    //exemple
    
//    @Override
//    @Transactional
//    public User getUser(String email, String pass) {
//        
//        return this.userDAO.getUser(email, pass);
//    }
    
    
    
}
