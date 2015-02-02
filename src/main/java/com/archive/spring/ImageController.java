/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring;

import com.archive.spring.dao.ImageDao;
import com.archive.spring.model.Image;
import com.archive.spring.model.User;
import com.archive.spring.service.ImageService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Iob
 */
@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    ImageDao imageDao;
    

    
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }
   @RequestMapping(value = "/index/liked", method = RequestMethod.GET)
    public String getLikedImages(Model m) {
        List<Image> images = imageDao.getLikedImages();
        m.addAttribute("images", images);
      //  m.addAttribute("page", 1);
        return "index";
    }
    
       @RequestMapping(value = "/index/download", method = RequestMethod.GET)
    public String getDownloadedImages(Model m) {
        List<Image> images = imageDao.getDownloadedImages();
        m.addAttribute("images", images);
      //  m.addAttribute("page", 1);
        return "index";
    }


    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public String listImages(Model model) {
        model.addAttribute("image", new Image());
        model.addAttribute("listImages", this.imageService.getAllImages());
        return "image";
    }
    
    @RequestMapping(value = "/SpringMVCHibernate/addImage", method = RequestMethod.GET)
    public String addImage(Model model) {
        model.addAttribute("addImage",new Image());
        return "addImage";
    }
    
     @RequestMapping(value = "/SpringMVCHibernate/detal/{id}", method = RequestMethod.GET)
    public String getImageById(@PathVariable int id, Model m) {
        m.addAttribute("image", imageService.getImageById(id));
        return null;
    }
    
    
    
}
