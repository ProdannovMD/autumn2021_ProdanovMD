package com.netcracker.application.controller;

import com.netcracker.application.service.UserService;
import com.netcracker.application.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getById(id));

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.update(id, user);
        return ResponseEntity.ok().build();

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity deleteUSer(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();

    }
}
