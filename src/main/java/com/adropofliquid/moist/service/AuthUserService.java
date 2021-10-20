package com.adropofliquid.moist.service;

import com.adropofliquid.moist.model.AuthUserDetails;
import com.adropofliquid.moist.model.Users;
import com.adropofliquid.moist.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthUserService implements UserDetailsService {


    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return usersToDetails(getUser(s));
    }

    private UserDetails usersToDetails(Users users){

        return new AuthUserDetails(
                users.getUsername(),
                users.getPassword(),
                true
        );
    }


    private Users getUser(String username){
        return userRepo.findByUsername(username);
    }

}
