package com.lld.expenesharing.main.exceptions;

public class ExpenseDoesNotExistsException extends Exception {
    public ExpenseDoesNotExistsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
