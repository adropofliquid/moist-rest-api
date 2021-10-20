package com.adropofliquid.moist.controller;

import com.adropofliquid.moist.model.Transfer;
import com.adropofliquid.moist.model.auth.AuthRequest;
import com.adropofliquid.moist.model.auth.AuthResponse;
import com.adropofliquid.moist.security.jwt.JwtUtil;
import com.adropofliquid.moist.service.TransferService;
import com.adropofliquid.moist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;



    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ResponseEntity<?> transfer(@RequestBody Transfer transfer) {

        transferFromPrincipal(transfer);
        return ResponseEntity.ok(transfer);
    }


    public void transferFromPrincipal(Transfer transfer) {

        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        transferService.makeTransfer(principal.getName(),transfer);
    }

}
