package com.adropofliquid.moist.controller;

import com.adropofliquid.moist.model.UserSignUp;
import com.adropofliquid.moist.model.Users;
import com.adropofliquid.moist.model.auth.AuthRequest;
import com.adropofliquid.moist.model.auth.AuthResponse;
import com.adropofliquid.moist.security.jwt.JwtUtil;
import com.adropofliquid.moist.service.AccountService;
import com.adropofliquid.moist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SignUp {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody UserSignUp user) {

        userService.addUserFromSignUp(user);
        return ResponseEntity.ok(user);
    }


}
