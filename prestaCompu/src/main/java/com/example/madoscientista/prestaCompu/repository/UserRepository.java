package com.example.madoscientista.prestaCompu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.madoscientista.prestaCompu.model.User;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    // Sección GET
    public List<User> getUsers(){
        return users;
    }

    public User getUserById(int id){
        for(User u : users){
            if(u.getId() == id){
                return u;
            }
        }

        return null;
    }

    // Sección POST
    public User postUser(User u){
        users.add(u);
        return u;
    }

    // Sección PUT
    public User putUser(int id, User user){
        User u = getUserById(id);

        u.setName(user.getName());
        u.setRole(user.getRole());

        return u;
    }

    // Sección DELETE
    public boolean deleteUser(int id){
        User u = getUserById(id);
        users.remove(u);
        return true;
    }
}
