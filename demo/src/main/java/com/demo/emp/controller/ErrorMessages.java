package com.demo.emp.controller;

public enum ErrorMessages {

    Employee_already_exists_in_the_database("Employee already exists in the database");
    // i made it

    private  String ErrorMessages;

    ErrorMessages(String errorMessages) {
        this.ErrorMessages = errorMessages;
    }

    public String getErrorMessages() {
        return ErrorMessages;
    }

    public void setErrorMessages(String errorMessages) {
        ErrorMessages = errorMessages;
    }
}
