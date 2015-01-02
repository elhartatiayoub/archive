/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring;

import com.archive.spring.model.User;
import com.archive.spring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Iob
 */
@Controller
public class ImageController {

    private ImageService imageService;

    @Autowired
    @Qualifier(value = "imageService")
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public String addPerson( Model model) {

        model.addAttribute("image", "/resources/pic.jpg");
        return "image";

    }
}
