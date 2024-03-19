package com.example.demo.Exception;

public class MensajeNotFoundException extends RuntimeException{
    public MensajeNotFoundException() {
        super();
    }

    public MensajeNotFoundException(String message) {
        super(message);
    }

    public MensajeNotFoundException(Throwable cause) {
        super(cause);
    }
}
