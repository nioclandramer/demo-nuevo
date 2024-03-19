package com.example.demo.Exception;

public class PartidaNotFoundException extends RuntimeException{
    public PartidaNotFoundException() {
        super();
    }

    public PartidaNotFoundException(String message) {
        super(message);
    }

    public PartidaNotFoundException(Throwable cause) {
        super(cause);
    }
}
