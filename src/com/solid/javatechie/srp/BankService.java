package com.solid.javatechie.srp;


// here bank service is doing all functionalities
public class BankService {


    // BankService will perform only deposit and withdraw functionality
    public long deposit(long amount , String accountNo){
        // deposit amount
        return 0;
    }

    public long withdraw(long amount , String accountNo){
        // withdraw amount
        return 0;
    }

    // can be moved to PrintService
    public void printPassbook(){
        // update transaction info in passbook
    }

    // can be moved to LoanService
    public void getLoanInterest(String loanType){
        if(loanType.equals("homeloan")){
            // do some job
        }
        if(loanType.equals("personalloan")){
            // do some job
        }
        if(loanType.equals("carloan")){
            // do some job
        }
    }

    // can be moved to NotificationService
    public void sendOtp(String medium){
        if(medium.equals("email")){
            // write email related logic
            // using java mail sender api
        }
    }
}
