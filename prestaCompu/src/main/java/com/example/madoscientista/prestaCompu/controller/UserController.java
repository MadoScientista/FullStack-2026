package com.example.madoscientista.prestaCompu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.madoscientista.prestaCompu.model.User;
import com.example.madoscientista.prestaCompu.service.UserService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UserController {

    @Autowired
    UserService service;

    // ---------- Sección GET ----------

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }

    // Obtener usuario por id
    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        if(service.getUserById(id) != null){
            return ResponseEntity.ok(service.getUserById(id));
        }

        return ResponseEntity.notFound().build();
    }

    // ------------- Sección POST --------------
    @PostMapping
    public ResponseEntity<?> postUser(User u){
        if(service.postUser(u) != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(u);
        }

        return ResponseEntity.badRequest().build();
    }

    
}
