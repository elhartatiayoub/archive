package com.archive.spring;

import com.archive.spring.form.UserInscriptionForm;
import com.archive.spring.form.UserSignForm;
import com.archive.spring.model.User;
import com.archive.spring.service.UserService;
import com.archive.spring.shiro.StringHash;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService ps) {
        this.userService = ps;
    }

    
    
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("UserInscriptionForm") UserInscriptionForm p ,BindingResult result, Model model) {
        User user = new User();
        if (!result.hasErrors()) {
            System.out.println(result.getFieldError().getField());
            user.setEmail(p.getEmail());
            user.setPassword(StringHash.hash(p.getPassword()));
            user.setName(p.getUsername());
            this.userService.addUser(user);
            model.addAttribute("user", user);
            return "index";
        }else{
            return "signup";
        }
    }
     @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String connUser(@Valid @ModelAttribute("UserSignForm") UserSignForm p ,BindingResult result, Model model) {
        User user = new User();
        if (result.hasErrors()) {
//            System.out.println(result.getFieldError().getField());
//            user.setName(p.getUsername());
//            user.setPassHash(StringHash.hash(p.getPass()));
//            user.setName(p.getUsername());
//            this.userService.addUser(user);
           user = this.userService.listUser().get(0);
            model.addAttribute("user", user);
            return "index";
        }else{
            return "signin";
        }
    }

 

    @RequestMapping("/")
    public String mainc(Model model) {
        if (model.containsAttribute("user")) {
            model.addAttribute("user", new User());
            return "redirect:/user";
        } else {
            model.addAttribute("user", new User());
            return "signup";
        }

    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUser());
        return "user";
    }
    
  

}
