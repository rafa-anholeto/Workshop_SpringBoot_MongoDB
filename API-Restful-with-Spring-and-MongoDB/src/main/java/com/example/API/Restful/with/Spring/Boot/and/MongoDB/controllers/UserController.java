package com.example.API.Restful.with.Spring.Boot.and.MongoDB.controllers;

import com.example.API.Restful.with.Spring.Boot.and.MongoDB.domain.Post;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.domain.User;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.dto.UserDTO;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = userService.findById(id);
        return new ResponseEntity<>(new UserDTO(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        User obj = userService.fromDTO(objDto);
        obj = userService.insert(obj);
        return new ResponseEntity(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
        User obj = userService.fromDTO(objDto);
        obj.setId(id);
        obj = userService.update(obj);
        return new ResponseEntity(obj, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User obj = userService.findById(id);
        return new ResponseEntity<>(obj.getPosts(), HttpStatus.OK);
    }



}
