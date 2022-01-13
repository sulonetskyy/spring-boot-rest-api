package com.example.ui.controller;

import com.example.ui.model.User;
import com.example.ui.model.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(@RequestParam(value="page", defaultValue = "1") int page,
                           @RequestParam(value="limit", defaultValue = "10") int limit,
                           @RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {
        return "get user was page: " + page + ", limit " + limit + ", sort " + sort;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{userId}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        final User user = new User(userId, "Hello", "World", "hello.world@example.com");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest) {
        final User user = new User("1", userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail());
        return new ResponseEntity<>(user, HttpStatus.OK);
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
