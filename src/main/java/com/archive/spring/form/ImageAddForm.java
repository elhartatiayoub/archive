/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.archive.spring.form;

import com.archive.spring.model.Category;
import java.io.File;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sara
 */
public class ImageAddForm {
    @NotNull
    String title;
    @NotNull
    String pravacy;
    File  url;
    String description;
    String[] keywords;
    Category category;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getPravacy() {
        return pravacy;
    }

    public File getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPravacy(String pravacy) {
        this.pravacy = pravacy;
    }

    public void setUrl(File url) {
        this.url = url;
    }
    
    
    
}
