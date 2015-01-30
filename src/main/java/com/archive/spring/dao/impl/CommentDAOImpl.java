/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring.dao.impl;

import com.archive.spring.dao.CommentDAO;
import com.archive.spring.model.Comment;
import com.archive.spring.model.Image;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Iob
 */
@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO{

    @Override
    public List<Comment> getCommentByImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addComment(String text, int imageID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteComment(int commentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
