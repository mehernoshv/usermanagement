package com.projects.usermanagement.exception;


public class MissingDataException extends Exception {

    private static final long serialVersionUID = 4779611655422378418L;

    public MissingDataException(String msg){
        super(msg);
    }
}
