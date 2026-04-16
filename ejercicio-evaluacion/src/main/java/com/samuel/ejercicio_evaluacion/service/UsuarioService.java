package com.samuel.ejercicio_evaluacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.ejercicio_evaluacion.model.Usuario;
import com.samuel.ejercicio_evaluacion.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> getUsuarios(){
        return repo.getUsuarios();
    }

    public Usuario getUsuarioById(int id){
        return repo.getUsuarioById(id);
    }

    public boolean deleteUsuario(int id){
        return repo.deleteUsuario(id);
    }

    public Usuario postUsuario(Usuario u){
        return repo.postUsuario(u);
    }

    public Usuario putUsuario(int id, Usuario u){
        return repo.putUsuario(id, u);
    }
}
