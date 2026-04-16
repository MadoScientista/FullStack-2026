package com.example.madoscientista.prestaCompu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.madoscientista.prestaCompu.model.Laptop;
import com.example.madoscientista.prestaCompu.service.LaptopService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/laptops")
public class LaptopController {

    @Autowired
    LaptopService service;

    // Sección GET
    @GetMapping
    public List<Laptop> getLaptops(){
        return service.getLaptops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptop(@PathVariable int id){
        Laptop l = service.getLaptopById(id);
        if(l != null){
            return ResponseEntity.ok(l);
        }

        return ResponseEntity.notFound().build();
    }

    // Sección POST
    @PostMapping
    public ResponseEntity<Laptop> postLaptop(@Valid @RequestBody Laptop l){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postLaptop(l));
    }

    // Sección DETELE
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLaptop(@PathVariable int id){
        Laptop l = service.getLaptopById(id);

        if(l != null){
            service.deleteLaptop(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
