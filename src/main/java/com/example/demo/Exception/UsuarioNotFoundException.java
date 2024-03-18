package com.example.demo.Exception;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException() {
        super();
    }

    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException(Throwable cause) {
        super(cause);
    }
}
