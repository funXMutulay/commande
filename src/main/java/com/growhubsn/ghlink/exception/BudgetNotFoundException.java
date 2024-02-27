package com.growhubsn.compta.budget.exception;

import java.lang.RuntimeException;

public class BudgetNotFoundException extends RuntimeException{
    
    public BudgetNotFoundException(Long id){
        super("Could not found the budget with id:" +id);
    }    
}