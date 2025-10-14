package com.scm.helper;

public class RuntimeExceptionThrow extends RuntimeException {

    public RuntimeExceptionThrow(String message){
        super(message);
    }
    RuntimeExceptionThrow(){
        super();
    }    
}
