/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.archive.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Iob
 */

@Entity
@Table(name="Image")
public class Image implements Serializable {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String descr;
    private int userID;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date CreationDate;
    private boolean isPrivate;
    private int likes;
    @ElementCollection
    @CollectionTable(name="KeyWords", joinColumns=@JoinColumn(name="ID_IMAGE"))
    private List<String> keyWords;
    private String URI;

    public Image(long id, String name, String desc,int user, Date CreationDate, boolean isPrivate, int likes, List<String> keyWords, String URI) {
        this.id = id;
        this.name = name;
        this.descr = desc;
        this.CreationDate = CreationDate;
        this.userID = user;
        this.isPrivate = isPrivate;
        this.likes = likes;
        this.keyWords = keyWords;
        this.URI = URI;
    }

    public Image() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date CreationDate) {
        this.CreationDate = CreationDate;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }
}
