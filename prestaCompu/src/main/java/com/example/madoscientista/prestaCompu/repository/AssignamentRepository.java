package com.example.madoscientista.prestaCompu.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.madoscientista.prestaCompu.model.Assignament;

@Repository
public class AssignamentRepository {
    private List<Assignament> assignaments = new ArrayList<>();

    // Sección GET
    public List<Assignament> getAssignaments(){
        return assignaments;
    }

    public Assignament getAssignamentById(int id){
        for(Assignament a: assignaments){
            if(a.getAssignamentId() == id){
                return a;
            }
        }

        return null;
    }

    public List<Assignament> getAssignamentsByUserId(int userId){
        List<Assignament> userAssignaments = new ArrayList<>();
        for(Assignament a : assignaments){
            if(a.getUserId() == userId){
                userAssignaments.add(a);
            }
        }
        return userAssignaments;

    }

    public List<Assignament> getAssignamentOverdue(int userId){
        List<Assignament> userAssignaments = new ArrayList<>();
        for(Assignament a : assignaments){
            if(a.getUserId() == userId && a.getAssignamentDate().plusDays(a.getDays()).isBefore(LocalDate.now())){
                userAssignaments.add(a);
            }
        }
        return userAssignaments;
    }

    // Sección POST
    public Assignament postAssignament(Assignament a){
        assignaments.add(a);
        return a;
    }

    // Sección DELETE
    public boolean deleteAssignament(int id){
        Assignament a = getAssignamentById(id);

        if(a != null){
            assignaments.remove(a);
            return true;
        }

        return false;
    }

    // Sección PUT
    public Assignament putAssignament(int id, Assignament assignament){
        Assignament a = getAssignamentById(id);

        if(a != null){
            a.setAssignamentDate(assignament.getAssignamentDate());
            a.setLaptopId(assignament.getLaptopId());
            a.setReturnDate(assignament.getReturnDate());
            a.setUserId(assignament.getUserId());
        }

        return a;
    }
}
