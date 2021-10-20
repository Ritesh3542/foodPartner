package com.project.foodPartner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.foodPartner.model.FoodUserDetails;
import com.project.foodPartner.model.fcustomers;
import com.project.foodPartner.repo.foodusersrepo;

@Service
public class FoodUserDetailsService implements UserDetailsService {

   @Autowired
   private foodusersrepo userRepository;
    
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       fcustomers user = userRepository.findByUsername(username);
       if (user == null) {
           throw new UsernameNotFoundException("Could not find user");
       }
        
       return new FoodUserDetails(user);
   }

}