package org.corrigentia.fitrest.cpl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> handleUsernameNotFound(UsernameNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    /*
     * @ExceptionHandler(Exception.class)
     * public ResponseEntity<Object> handlePrecondition(Exception e) {
     * return ResponseEntity.badRequest().body(e.getMessage());
     * }
     */
}
