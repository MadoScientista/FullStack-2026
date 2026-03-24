package com.madoscientista.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madoscientista.biblioteca.model.Loan;
import com.madoscientista.biblioteca.repository.LoanRepository;

@Service
public class LoanService {

    @Autowired
    LoanRepository repo;

    public List<Loan> getLoans(){
        return repo.getLoans();
    }

    public Loan postLoan(Loan l){
        return repo.postLoan(l);
    }

    public Loan getLoanById(int id){
        return repo.getLoanById(id);
    }

    public Loan putLoan(int id, Loan l){
        return repo.putLoan(id, l);
    }

    public boolean deleteLoan(int id){
        return repo.deleteLoan(id);
    }
}
