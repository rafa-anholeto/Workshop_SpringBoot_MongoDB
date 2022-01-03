package com.example.API.Restful.with.Spring.Boot.and.MongoDB.controllers;

import com.example.API.Restful.with.Spring.Boot.and.MongoDB.domain.User;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
