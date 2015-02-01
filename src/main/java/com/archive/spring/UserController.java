package com.archive.spring;


import com.archive.spring.form.UserInscriptionForm;
import com.archive.spring.form.UserSignForm;
import com.archive.spring.model.Category;
import com.archive.spring.model.Image;
import com.archive.spring.model.Role;
import com.archive.spring.model.User;
import com.archive.spring.service.UserService;
import com.archive.spring.shiro.StringHash;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService ps) {
        this.userService = ps;
    }

    @RequestMapping(value = "/populate")
    public String populate() {
        Transaction t = null;
        try {
            org.hibernate.Session session = sessionFactory.getCurrentSession();
            String hql = "FROM Role I WHERE I.name=:name";
            String[] s1 = {"word2","word4"};
            String[] s2 = {"word3","word1"};
            Role role = null;
            t = session.beginTransaction();
            Query q = session.createQuery(hql);
            q.setParameter("name", "user");
            List<Role> l = q.list();
            if (!l.isEmpty()) {
                role = l.get(0);
            }
            
            Category category1 = new Category();
            category1.setName("cat1");
            session.persist(category1);
            Category category2 = new Category();
            category1.setName("cat2");
            session.persist(category2);
            
            User u1 = new User();
            u1.setEmail("user1@ensa.ma");
            u1.setName("user1");
            u1.setRole(role);
            u1.setPassHash(StringHash.hash("123123"));
            
            User u2 = new User();
            u2.setEmail("user2@ensa.ma");
            u2.setName("user2");
            u2.setRole(role);
            u2.setPassHash(StringHash.hash("123123"));
            
            session.persist(u1);
            session.persist(u2);
            
            Image image = null;
            
            for(int i=0;i<15;i++){
                image = new Image();
                if(i<7){
                    image.setCategory(category1);
                }else{
                    image.setCategory(category2);
                }
                image.setDate(new Date());
                image.setDownloads((int)(Math.random()*100));
                image.setLikes((int)(Math.random()*100));
                if(i<5){
                    image.setPravacy("public");
                }else{
                   image.setPravacy("private"); 
                }
                image.setShares((int)(Math.random()*100));
                image.setTitle("image"+i);
                image.setUrl("urlimage"+i);
                image.setKeywords(new String[] {"Ankit","Bohra","Xyz"});
                

                u1.addImage(image);    
            }
            
            for(int i=0;i<13;i++){
                image = new Image();
                if(i<5){
                    image.setCategory(category1);
                }else{
                    image.setCategory(category2);
                }
                image.setDate(new Date());
                image.setDownloads((int)(Math.random()*100));
                image.setLikes((int)(Math.random()*100));
                if(i<8){
                    image.setPravacy("public");
                }else{
                   image.setPravacy("private"); 
                }
                image.setShares((int)(Math.random()*100));
                image.setTitle("image"+i);
                image.setUrl("urlimage"+i);
                image.setKeywords(new String[] {"jjjff","Bofffhra","Xyjghfz"});
                u2.addImage(image);    
            }
            session.update(u1);
            session.update(u2);
            t.commit();
            
            
        }catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
 
        return "index";
    }

    @RequiresGuest
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("UserInscriptionForm") UserInscriptionForm p, BindingResult result, Model model) {
        User user = new User();
        if (result.hasErrors()) {
            System.out.println(result.getFieldError().getField());
            user.setEmail(p.getEmail());
            user.setPassHash(StringHash.hash(p.getPassword()));
            user.setName(p.getUsername());
            this.userService.addUser(user);
            model.addAttribute("user", user);
            return "index";
        } else {
            return "signup";
        }
    }
//     @RequestMapping(value = "/connect")
//    public String connUser(@Valid @ModelAttribute("UserSignForm") UserSignForm p ,BindingResult result, Model model) {
//        User user = new User();
//        if (result.hasErrors()) {
////            System.out.println(result.getFieldError().getField());
////            user.setName(p.getUsername());
////            user.setPassHash(StringHash.hash(p.getPass()));
////            user.setName(p.getUsername());
////            this.userService.addUser(user);
//           user = this.userService.listUser().get(0);
//            model.addAttribute("user", user);
//            return "index";
//        }else{
//            return "signin";
//        }
//    }

    @RequiresGuest
    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String submitLoginForm(@Valid UserSignForm loginUser, BindingResult result, Model m, HttpServletRequest request) {
        if (!result.hasErrors()) {
            try {
                User userTemp = new User();
                userTemp.setEmail(loginUser.getUsername());
                userTemp.setPassHash(loginUser.getPass());

                Subject subject = SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(userTemp.getEmail(), userTemp.getPassHash(), loginUser.isField()));
                Session session = subject.getSession(true);
                session.setAttribute("user", userTemp);
                session.setTimeout(24 * 3600000);
                m.addAttribute("message", "Successfully logged in person");
                String referer = request.getHeader("referer");
                if (referer != null && !referer.isEmpty()) {
                    return "redirect:" + referer;
                }
                referer = (String) SecurityUtils.getSubject().getSession().getAttribute("fallback");
                if (referer != null && !referer.isEmpty()) {
                    return "redirect:" + referer;
                }
            } catch (AuthenticationException ex) {
                ex.printStackTrace();
                m.addAttribute("message", "It seems your email is not registered.");
            }
        }
        return "login";
    }

}
