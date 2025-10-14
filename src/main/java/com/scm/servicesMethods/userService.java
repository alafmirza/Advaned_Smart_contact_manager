package com.scm.servicesMethods;
import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface userService {
    
   //save 
   User saveUser(User user);

   //find by id
   Optional<User> singleUser(String id);

   //find all
   List<User> allUsers();

   //find by email
   User emailUser(String email);

   //update
  Optional<User> updateUser(User user);

   //delete
   void deleteUser(String id);

   //userexist by id
   boolean isUserExist(String id);

   //userexist by emai
   boolean isUserExistByemail(String email);
 
}
