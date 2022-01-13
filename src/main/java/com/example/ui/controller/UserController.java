package com.example.ui.controller;

import com.example.ui.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(@RequestParam(value="page", defaultValue = "1") int page,
                           @RequestParam(value="limit", defaultValue = "10") int limit,
                           @RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {
        return "get user was page: " + page + ", limit " + limit + ", sort " + sort;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    public User getUser(@PathVariable String userId) {
        final User user = new User(userId, "Hello", "World", "hello.world@example.com");
        return user;
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
