package com.example.API.Restful.with.Spring.Boot.and.MongoDB.services;

import com.example.API.Restful.with.Spring.Boot.and.MongoDB.domain.User;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();

    }
}
