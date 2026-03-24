package com.madoscientista.biblioteca.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.madoscientista.biblioteca.model.Loan;

@Repository
public class LoanRepository {
    private List<Loan> loans = new ArrayList<>();

    public LoanRepository(){
        loans.add(new Loan(1, 1, "10.585.012-6", LocalDate.parse("2026-12-01"), LocalDate.parse("2026-12-30"), 3, 0));
        loans.add(new Loan(2, 1, "10.585.012-6", LocalDate.parse("2026-12-02"), LocalDate.parse("2026-12-30"), 3, 0));
        loans.add(new Loan(3, 3, "10.585.012-6", LocalDate.parse("2026-12-02"), LocalDate.parse("2026-12-28"), 3, 0));
        loans.add(new Loan(4, 4, "10.585.012-6", LocalDate.parse("2026-12-20"), LocalDate.parse("2026-12-27"), 3, 0));
        loans.add(new Loan(5, 15, "10.585.012-6", LocalDate.parse("2026-12-20"), LocalDate.parse("2026-12-26"), 3, 0));
    }

    public List<Loan> getLoans(){
        return loans;
    }

    public Loan postLoan(Loan l){
        loans.add(l);
        return l;
    }

    public Loan getLoanById(int id){
        for (Loan l : loans){
            if(l.getLoanId() == id){
                return l;
            }
        }

        return null;
    }

    public Loan putLoan(int id, Loan loan){
        for(Loan l : loans){
            if(l.getLoanId() == id){
                l.setDays(loan.getDays());
                l.setFines(loan.getFines());
                l.setLoanDate(loan.getLoanDate());
                l.setReturnDate(loan.getReturnDate());
                l.setBookId(loan.getBookId());
                l.setRun(loan.getRun());

                return l;
            }
        }

        return null;
    }

    public boolean deleteLoan(int id){
        for(Loan l : loans){
            if(l.getLoanId() == id){
                loans.remove(id);
                return true; 
            }
        }

        return false;
    }
}
