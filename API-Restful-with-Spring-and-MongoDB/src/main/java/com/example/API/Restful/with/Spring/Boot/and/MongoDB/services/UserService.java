package com.example.API.Restful.with.Spring.Boot.and.MongoDB.services;

import com.example.API.Restful.with.Spring.Boot.and.MongoDB.domain.User;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.dto.UserDTO;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.repositories.UserRepository;
import com.example.API.Restful.with.Spring.Boot.and.MongoDB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert (User obj){
        return userRepository.insert(obj);
    }

    public User update(User obj){
        Optional<User> newObj = userRepository.findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(obj);
    }

    private void updateData(Optional<User> newObj, User obj) {
        newObj.stream().map(x -> x.getName());
        newObj.stream().map(x -> x.getEmail());
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
