package com.example.javaBlog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.javaBlog.Model.UserPrincipal;
import com.example.javaBlog.Model.Users;
import com.example.javaBlog.Repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByUsername(username);

        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);

    }

}
