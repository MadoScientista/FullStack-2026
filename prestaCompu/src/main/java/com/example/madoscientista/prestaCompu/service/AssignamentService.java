package com.example.madoscientista.prestaCompu.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.madoscientista.prestaCompu.model.Assignament;
import com.example.madoscientista.prestaCompu.model.Laptop;
import com.example.madoscientista.prestaCompu.model.User;
import com.example.madoscientista.prestaCompu.repository.AssignamentRepository;

@Service
public class AssignamentService {

    @Autowired
    AssignamentRepository repo;
    LaptopService laptopService;
    UserService userService;
    Laptop laptopModel;
    User userModel;

    // Sección GET
    public List<Assignament> getAssignaments(){
        return repo.getAssignaments();
    }

    public Assignament getAssignamentById(int id){
        return repo.getAssignamentById(id);
    }

    // Sección POST
    public Assignament postAssignament(Assignament a){
        a.setAssignamentDate(LocalDate.now());
        laptopModel = laptopService.getLaptopById(a.getLaptopId());
        userModel = userService.getUserById(a.getUserId());

        if(userModel == null || !repo.getAssignamentOverdue(a.getUserId()).isEmpty()){
            return null;
        }

        if(laptopModel == null || laptopModel.isAssigned()){
            return null;
        }

        laptopModel.setAssigned(true);
        laptopService.puLaptop(laptopModel.getId(), laptopModel);
        return repo.postAssignament(a);

    }

    // Sección DELETE
    public boolean deleteAssignament(int id){
        Assignament a = repo.getAssignamentById(id);
        if(a != null){
            repo.deleteAssignament(id);
            return true;
        }

        return false;
    }

    // Sección PUT
    public Assignament putAssignament(int id, Assignament assignament){
        Assignament a = repo.getAssignamentById(id);
        
        if(a != null && id == assignament.getAssignamentId()){
            return repo.putAssignament(id, assignament);
        }

        return null;

    }
}
