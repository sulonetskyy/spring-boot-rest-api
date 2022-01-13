package com.example.ui.controller;

import com.example.ui.model.User;
import com.example.ui.model.UserRequest;
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
    public User createUser(@RequestBody UserRequest userRequest) {
        final User user = new User("1", userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail());
        return user;
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
