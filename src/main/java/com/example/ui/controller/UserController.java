package com.example.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String getUser() {
        return "get user was called";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser() {
        return "create user was called";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateUSer() {
        return "update user was called";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteUSer() {
        return "delete user was called";
    }
}
