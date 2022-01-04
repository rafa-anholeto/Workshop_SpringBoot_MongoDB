package com.example.API.Restful.with.Spring.Boot.and.MongoDB.controllers.exception;

import com.example.API.Restful.with.Spring.Boot.and.MongoDB.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(),"Não encontrado", e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
}
