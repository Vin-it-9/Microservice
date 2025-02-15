package org.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.userservice.entity.User;
import org.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("")
    public List<User> getAll() {
        return userService.findAllUsers();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/findByEmail/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @PostMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/update/{id}")
    public User updateUser(@RequestBody User user ,@PathVariable Integer id) {
        return userService.updateUser(user,id);
    }










}
