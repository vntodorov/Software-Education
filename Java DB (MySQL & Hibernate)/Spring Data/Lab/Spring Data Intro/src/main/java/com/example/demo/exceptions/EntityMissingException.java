package com.example.demo.exceptions;

public class EntityMissingException extends RuntimeException{

    public EntityMissingException(String msg){
        super(msg);
    }
}
