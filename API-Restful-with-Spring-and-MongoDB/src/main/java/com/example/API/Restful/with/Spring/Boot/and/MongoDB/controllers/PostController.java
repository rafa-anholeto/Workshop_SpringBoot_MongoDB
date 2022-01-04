package com.example.API.Restful.with.Spring.Boot.and.MongoDB.controllers;

import com.example.API.Restful.with.Spring.Boot.and.MongoDB.controllers.util.URL;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.domain.Post;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "text", defaultValue = "") String minDate,
                                                 @RequestParam(value = "text", defaultValue = "") String maxDate){

        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = postService.fullSearch(text, min, max);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



}
