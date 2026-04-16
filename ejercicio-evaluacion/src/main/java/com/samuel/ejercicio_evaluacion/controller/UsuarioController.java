package com.samuel.ejercicio_evaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.ejercicio_evaluacion.model.Usuario;
import com.samuel.ejercicio_evaluacion.service.UsuarioService;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> getUsuarios(){
        return service.getUsuarios();
    }

    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable int id){
        return service.getUsuarioById(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteUsuario(@PathVariable int id){
        return service.deleteUsuario(id);
    }

    @PostMapping
    public Usuario postUsuario(@RequestBody Usuario u){
        return service.postUsuario(u);
    }

    @PutMapping("{id}")
    public Usuario putUsuario(@PathVariable int id, @RequestBody Usuario u){
        return service.putUsuario(id, u);
    }

}
