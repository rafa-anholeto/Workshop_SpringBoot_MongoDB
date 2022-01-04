package com.example.API.Restful.with.Spring.Boot.and.MongoDB.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
