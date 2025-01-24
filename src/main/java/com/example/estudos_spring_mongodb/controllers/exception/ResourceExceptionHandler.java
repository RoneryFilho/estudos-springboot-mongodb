package com.example.estudos_spring_mongodb.controllers.exception;

import com.example.estudos_spring_mongodb.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Objeto não encontrado", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

}
