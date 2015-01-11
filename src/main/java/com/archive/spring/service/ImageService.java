/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.archive.spring.service;

import com.archive.spring.model.Image;
import java.util.List;

/**
 *
 * @author Iob
 */
public interface ImageService {
            public void addImage(Image img);
            public void updateImage(Image img);
            public Image getImageById(int id);
            public List<Image> getAllImages();
            public void removeImage(int id);
}
