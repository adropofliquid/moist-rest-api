package com.adropofliquid.moist.service;

import com.adropofliquid.moist.model.Account;
import com.adropofliquid.moist.model.AuthUserDetails;
import com.adropofliquid.moist.model.UserSignUp;
import com.adropofliquid.moist.model.Users;
import com.adropofliquid.moist.repo.AccountRepository;
import com.adropofliquid.moist.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AccountRepository accountRepository;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usersToDetails(getUser(s));
    }

    private UserDetails usersToDetails(Users users){

        return new AuthUserDetails(
                users.getUsername(),
                users.getPassword(),
                users.getEnabled()
        );
    }


    public Users getUser(String username){
        return userRepo.findByUsername(username);
    }

    public void addUser(Users users){
        userRepo.save(users);
    }



    public void addUserFromSignUp(UserSignUp user) {
        addUser(signUpTousers(user));
        accountForNewUser(user);
    }

    private Users signUpTousers(UserSignUp userSignUp){

        Users user = new Users();
        user.setUsername(userSignUp.getUsername());
        user.setPassword(userSignUp.getPassword());
        user.setFname(userSignUp.getFname());
        user.setLname(userSignUp.getLname());
        user.setEnabled(true);
        return user;
    }

    public void accountForNewUser(UserSignUp user){
        Account account  = new Account();
        account.setBalance(0);
        account.setUserId(userRepo.findByUsername(user.getUsername()).getId());
        accountRepository.save(account);
    }

    public List<Users> getAllUsers() {
        List<Users> people = new ArrayList<>();
        userRepo.findAll().forEach(people::add);
        return people;
    }
}