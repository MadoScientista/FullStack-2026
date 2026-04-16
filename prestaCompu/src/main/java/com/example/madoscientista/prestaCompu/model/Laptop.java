package com.example.madoscientista.prestaCompu.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    
    private int id;
    @NotBlank
    private String marca;
    @NotBlank
    private String model;
    private int nSerie;
    private boolean isAssigned;
}
