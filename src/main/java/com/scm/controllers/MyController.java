package com.scm.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.entities.userForm;

import org.springframework.ui.Model;



@Controller
public class MyController {
  
  // index
     @GetMapping("/index")
    public String handler(Model model){
        //passing these values to view in form of keys

          model.addAttribute("name","Alaf Mirza");
          model.addAttribute("age","21");
          model.addAttribute("GitHub", "https://github.com/alafmirza");
          model.addAttribute("age", "my age is 21 and i am  ");
          return "index.html";
    }

     //about
      @GetMapping("/about")
      public String abouthandler(Model model){
        model.addAttribute("name", "Alaf Baig");
        return "about.html";
      }


     @GetMapping("/service")
      public String servicehandler(){
        return "service.html";
      }

      @GetMapping("/home")
      public String homehandler(){
        return "home.html";
      }

      @GetMapping("/contact")
      public String contacthandler(){
        return "contact.html";
      }
      
      @GetMapping("/login")
      public String loginhander() {
        return "login.html";
      }

      @GetMapping("/signup")
      public String signuphandler(Model model){
        model.addAttribute("userForm", new userForm());
        return "signup.html";
      }

      //for sucess page
      @PostMapping("/form")
      public String formhandler(@ModelAttribute ("userForm") userForm user){
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getPh());
        System.out.println(user.getAbout());
        return "sucess";
      }
}
