/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring.model;

import javax.validation.constraints.NotNull;


/**
 *
 * @author Iob
 */
public class UserForm {
    @NotNull(message = "nq")
    String name;
    String email;
    String pass;
    
    
}
