package com.urban.usersservice.exceptions;

public class PersonNotFoundException extends Exception{

    public PersonNotFoundException(String role){
        super(role+" not found!");
    }
}
