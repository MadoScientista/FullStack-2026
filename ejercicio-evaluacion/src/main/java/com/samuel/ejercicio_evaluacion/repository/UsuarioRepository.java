package com.samuel.ejercicio_evaluacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.samuel.ejercicio_evaluacion.model.Usuario;

@Repository
public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioRepository(){
        usuarios.add(new Usuario(1, "Samuel", "123123", 24));
        usuarios.add(new Usuario(2, "Natalia", "123asd", 25));
        usuarios.add(new Usuario(3, "Carmen", "123qwe", 24));
        usuarios.add(new Usuario(4, "Alejandro", "123eee", 30));
    }
    
    
    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public Usuario getUsuarioById(int id){
        for (Usuario u : usuarios){
            if(u.getIdUsuario() == id){
                return u;
            }
        }
        return null;
    }

    public boolean deleteUsuario(int id){
        Usuario u = getUsuarioById(id);

        if(u == null){
            return false;
        }
        usuarios.remove(u);

        return true;
    }

    public Usuario postUsuario(Usuario u){
        usuarios.add(u);
        return u;
    }

    public Usuario putUsuario(int id, Usuario u){
        Usuario usuario = getUsuarioById(id);

        if(usuario == null){
            return null;
        }

        usuario.setEdad(u.getEdad());
        usuario.setNombre(u.getNombre());
        usuario.setRut(u.getRut());

        return usuario;
    }
}
