package com.adropofliquid.moist.controller;

import com.adropofliquid.moist.model.Users;
import com.adropofliquid.moist.model.auth.AuthRequest;
import com.adropofliquid.moist.model.auth.AuthResponse;
import com.adropofliquid.moist.security.jwt.JwtUtil;
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
public class Login {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {

        return ResponseEntity.ok(authenticateUser(authRequest));
    }


    private AuthResponse authenticateUser(AuthRequest authRequest) throws Exception {

       try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);

        return new AuthResponse(jwt);
    }

}
