package com.projects.usermanagement.exception;


public class ObjectAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 4779611655422378418L;

    public ObjectAlreadyExistsException(String msg){
        super(msg);
    }
}
