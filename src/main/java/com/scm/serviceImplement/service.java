package com.scm.serviceImplement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scm.dao.userRepository;
import com.scm.entities.User;
import com.scm.helper.RuntimeExceptionThrow;
import com.scm.servicesMethods.userService;

@Component
public class service implements userService{
    Logger log = LoggerFactory.getLogger(service.class);

    @Autowired
     userRepository userRepository;


    @Override
    public User saveUser(User user) {
           user.setUserId(UUID.randomUUID().toString());
            return userRepository.save(user);  
    }

    @Override
    public Optional<User> singleUser(String id) {
             return userRepository.findById(id);
    }

    @Override
    public List<User> allUsers() {
            return userRepository.findAll();
    }

    @Override
    public User emailUser(String email) {
            return userRepository.findByEmail(email);

    }

    @Override
    public Optional<User> updateUser(User newuser) {
            User oldUser = userRepository.findById(newuser.getUserId()).orElseThrow(()-> new RuntimeExceptionThrow("User Not Found"));
            oldUser.setName(newuser.getName());
            oldUser.setEmail(newuser.getEmail());
            oldUser.setPassword(newuser.getPassword());
            oldUser.setAbout(newuser.getAbout());
            oldUser.setPh(newuser.getPh());
            oldUser.setEnabled(newuser.isEnabled());
            oldUser.setEmailVarified(newuser.isEmailVarified());
            oldUser.setPhVarified(newuser.isPhVarified());
            oldUser.setProvider(newuser.getProvider());
            oldUser.setProviderId(newuser.getProviderId());
            oldUser.setProfile(newuser.getProfile());
            User save =  userRepository.save(oldUser);  
            return Optional.of(save);
         
    }

    @Override
    public void deleteUser(String id) {
            User user = userRepository.findById(id).orElseThrow(()-> new RuntimeExceptionThrow("User not found"));
            userRepository.delete(user); 

    }

    @Override
    public boolean isUserExist(String id) {

            User user =  userRepository.findById(id).orElse(null);
            return user!=null ? true : false;

    }

    @Override
    public boolean isUserExistByemail(String email) {
            User user = userRepository.findByEmail(email);
            return user != null ? true : false;
    }
    
}