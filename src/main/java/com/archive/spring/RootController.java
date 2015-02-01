/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Iob
 */
@Controller
public class RootController {
    
    //to be removed
    @RequestMapping("users")
    public String userslist(){
        return "user";
    }
    
    @RequestMapping("/forgot")
    public String forgot() {
        return "forgot";

    }
    
    @RequestMapping("/index")
    public String index() {
        return "index";

    }
      @RequestMapping("/profile")
    public String profil() {
        return "profile";

    }
    @RequiresGuest
    @RequestMapping("/signup")
    public String SignUpRedirect() {
        return "signup";

    }
     @RequestMapping("/signin")
    public String signin() {
        return "signin";

    }
    

    
      @RequestMapping("/account_setting")
    public String editUser() {
        return "account_setting";

    }
       @RequestMapping("/404")
    public String erreur() {
        return "404";
    }
    
    @ExceptionHandler(UnauthenticatedException.class)
    public String shiroUnauthenticatedException() {
        return "index";
    }




    @ExceptionHandler(JDBCConnectionException.class)
    public String handleJDBCError(JDBCConnectionException exception) {
        exception.printStackTrace();
        return "404";
    }

    @ExceptionHandler(Exception.class)
    public String handleGlobalError(Exception exception) {
        exception.printStackTrace();
        return "404";
    }
}
