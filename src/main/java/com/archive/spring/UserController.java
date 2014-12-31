package com.archive.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.archive.spring.model.User;
import com.archive.spring.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	
	
	//For add and update person both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("user") User p,Model model){
	
		this.userService.addUser(p);
                model.addAttribute("user", p);
                model.addAttribute("listUsers", this.userService.listUser());
                return "user";
		
	}

 
    @RequestMapping(value="/user/connect", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user")User u, Model model){
        User user = (User) this.userService.getUser(u.getEmail(),u.getPass());
        System.out.println(u);
        if(user == null)
            return "inscription";
        else
            model.addAttribute("user", user);
        return "user";
    }
    
    @RequestMapping("/")
    public String mainc(Model model){
        if(model.containsAttribute("user")){
            model.addAttribute("user", new User());
            return "redirect:/user";
        }else{
            model.addAttribute("user", new User());
            return "inscription";
        }
        
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUser());
        return "user";
    }
	
}
