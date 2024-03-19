package com.example.demo.Exception;

public class SugerenciaNotFoundException extends RuntimeException{
    public SugerenciaNotFoundException() {
        super();
    }

    public SugerenciaNotFoundException(String message) {
        super(message);
    }

    public SugerenciaNotFoundException(Throwable cause) {
        super(cause);
    }
}
