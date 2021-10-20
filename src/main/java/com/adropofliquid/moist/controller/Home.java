package com.adropofliquid.moist.controller;

import com.adropofliquid.moist.model.Users;
import com.adropofliquid.moist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Home {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public List<Users> getAll() {
        return userService.getAllUsers();
    }
/*
    [
    {
        "id": 1,
            "username": "fun",
            "password": "fun",
            "lname": "clarity",
            "fname": "stone",
            "enabled": true
    },
    {
        "id": 2,
            "username": "story",
            "password": "story",
            "lname": "friend",
            "fname": "best",
            "enabled": true
    },
    {
        "id": 3,
            "username": "money",
            "password": "money",
            "lname": "abundance",
            "fname": "allow",
            "enabled": true
    },
    {
        "id": 4,
            "username": "ground",
            "password": "ground",
            "lname": "universe",
            "fname": "based",
            "enabled": true
    },
    {
        "id": 5,
            "username": "work",
            "password": "work",
            "lname": "oiled",
            "fname": "well",
            "enabled": true
    }
]
        */


}
