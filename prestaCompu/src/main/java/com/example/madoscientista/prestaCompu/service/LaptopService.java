package com.example.madoscientista.prestaCompu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.madoscientista.prestaCompu.model.Laptop;
import com.example.madoscientista.prestaCompu.repository.LaptopRepository;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository repo;

    // Sección GET
    public List<Laptop> getLaptops(){
        return repo.getLaptops();
    }

    public Laptop getLaptopById(int id){
        return repo.getLaptopById(id);
    }

    // Sección POST
    public Laptop postLaptop(Laptop l){
        return repo.postLaptop(l);
    }

    // Sección DELETE
    public boolean deleteLaptop(int id){
        return repo.deleteLaptop(id);
    }

    // Sección PUT
    public Laptop puLaptop(int id, Laptop l){
        return repo.putLaptop(id, l);
    }
}
