package com.madoscientista.biblioteca.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    private int loanId, bookId;
    private String run;
    private LocalDate loanDate, returnDate;
    private int days, fines; 
}
