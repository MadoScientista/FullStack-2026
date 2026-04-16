package com.example.madoscientista.prestaCompu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.madoscientista.prestaCompu.model.Laptop;

@Repository
public class LaptopRepository {
    private List<Laptop> laptops = new ArrayList<>();

    public LaptopRepository(){
        laptops.add(new Laptop(1, "Toshiba", "Básico", 1111, false));
        laptops.add(new Laptop(2, "Toshiba", "Medio", 2222, false));
        laptops.add(new Laptop(3, "Asus", "Básico", 3333, false));
        laptops.add(new Laptop(4, "Dell", "Avanzado", 4444, false));
        laptops.add(new Laptop(5, "HP", "Full", 5555, false));
    }

    // Sección GET
    public List<Laptop> getLaptops(){
        return laptops;
    }

    public Laptop getLaptopById(int id){
        for(Laptop l : laptops){
            if(l.getId() == id){
                return l;
            }
        }

        return null;
    }

    // Sección POST
    public Laptop postLaptop(Laptop l){
        laptops.add(l);
        return l;
    }

    // Sección DELETE
    public boolean deleteLaptop(int id){
        Laptop l = getLaptopById(id);

        if(l != null){
            laptops.remove(l);
            return true;
        }

        return false;
    }

    // Sección PUT
    public Laptop putLaptop(int id, Laptop laptop){
        for(Laptop l : laptops){
            if(l.getId() == id){
                l.setAssigned(laptop.isAssigned());
                l.setMarca(laptop.getMarca());
                l.setModel(laptop.getModel());
                l.setNSerie(laptop.getNSerie());
                return l;
            }
        }

        return null;
    }
}
