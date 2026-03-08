package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserCreateDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @PostMapping
    public ResponseEntity<String> createUser(
        @Valid @RequestBody UserCreateDto dto
    ){
        return ResponseEntity.ok("User created: " + dto.getUsername());
    }
}
