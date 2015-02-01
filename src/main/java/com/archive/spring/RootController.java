/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring;

import org.springframework.stereotype.Controller;
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
     @RequestMapping("/addImage")
    public String addImage(){
        return "addImage";
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
    @RequestMapping("/SignUp")
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
}
