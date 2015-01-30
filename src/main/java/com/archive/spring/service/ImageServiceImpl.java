/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.archive.spring.service;

import com.archive.spring.dao.ImageDao;
import com.archive.spring.model.Image;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Iob
 */

@Service
public class ImageServiceImpl implements ImageService{
    
    @Autowired
    @Qualifier(value = "imageDao")
    private ImageDao imageDao;

    
    public void setImageDao(ImageDao imageDao) {
        this.imageDao = imageDao;
    }
    
   

    @Override
    public void addImage(Image img) {
            this.imageDao.addImage(img);
    }

    @Override
    public void updateImage(Image img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getImageById(int id) { 
        return  this.imageDao.getImageById(id);
    }

    @Override
    public List<Image> getAllImages() {
            return this.imageDao.getAllImages();
    }

    @Override
    public void removeImage(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
