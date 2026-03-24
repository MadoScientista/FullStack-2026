package com.madoscientista.biblioteca.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madoscientista.biblioteca.model.Loan;
import com.madoscientista.biblioteca.service.LoanService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/v1/solicitudes")
public class LoanController {

    @Autowired
    LoanService service;


    @GetMapping
    public ResponseEntity<?> getLoans(){
        return ResponseEntity.ok(service.getLoans());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getLoanById(@PathVariable int id){

        Loan l = service.getLoanById(id);
        if( l != null){
            return ResponseEntity.ok(l);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> postLoan(@RequestBody Loan l){
        if(service.postLoan(l) != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(l);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Asegúrese que los campos de préstamo están bien construidos");
    } 

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLoan(@PathVariable int id){
        if(service.deleteLoan(id)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putLoan(@PathVariable int id, @RequestBody Loan l){
        Loan loan = service.putLoan(id, l);
        if(loan != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(loan);
        }

        return ResponseEntity.badRequest().body("No se ha encontrado el préstamo con id: " + id);
    }
}
