package com.scm.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scm.dao.userRepository;

@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    userRepository uRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return uRepository.findByEmail(username);

    }
    
    
}
