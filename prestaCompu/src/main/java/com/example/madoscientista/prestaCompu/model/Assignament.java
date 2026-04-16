package com.example.madoscientista.prestaCompu.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignament {
    private int assignamentId;
    private int userId;
    private int laptopId;
    private int days;
    private LocalDate assignamentDate, returnDate;
}
