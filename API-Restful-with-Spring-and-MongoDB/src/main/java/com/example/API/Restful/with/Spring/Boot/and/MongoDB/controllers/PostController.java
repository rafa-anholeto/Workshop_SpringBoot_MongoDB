package com.example.API.Restful.with.Spring.Boot.and.MongoDB.controllers;

import com.example.API.Restful.with.Spring.Boot.and.MongoDB.domain.Post;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = postService.findById(id);
        return new ResponseEntity<>(obj , HttpStatus.OK);
    }




}
