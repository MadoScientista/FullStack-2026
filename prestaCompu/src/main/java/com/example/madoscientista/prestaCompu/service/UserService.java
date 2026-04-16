package com.example.madoscientista.prestaCompu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.madoscientista.prestaCompu.model.User;
import com.example.madoscientista.prestaCompu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    // Sección GET
    public List<User> getUsers(){
        return repo.getUsers();
    }

    public User getUserById(int id){
        return repo.getUserById(id);
    }

    // Sección POST
    public User postUser(User u){
        return repo.postUser(u);
    }

    // Sección PUT
    public User putUser(int id, User user){
        User u = repo.getUserById(id);

        if(u != null && id == user.getId()){
            return repo.putUser(id, user);
        }

        return null;
    }

    // Sección DELETE
    public boolean deleteUser(int id){
        User u = repo.getUserById(id);
        if(u != null){
            return repo.deleteUser(id);
        }

        return false;
    }
    
}
