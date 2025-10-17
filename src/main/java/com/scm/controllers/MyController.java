package com.scm.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.entities.Provider;
import com.scm.entities.User;
import com.scm.entities.userForm;
import com.scm.serviceImplement.service;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class MyController {
  @Autowired
  service service;

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
      public String formhandler(@Valid @ModelAttribute ("userForm") userForm userFo , BindingResult result){
      //triger errors
      if(result.hasErrors()){
        return "/signup";
      }

   //convert userform into user
     User user = new User();
     user.setName(userFo.getName());
     user.setEmail(userFo.getEmail());
     user.setPassword(userFo.getPassword());
     user.setPh(userFo.getPh());
     user.setAbout(userFo.getAbout());
     user.setProvider(Provider.SELF);
     user.setProfile("https://images.unsplash.com/photo-1585972949687-48eff8b879a9?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=1332");
     service.saveUser(user);
        return "sucess";
      }
}
