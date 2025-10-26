package br.com.fiap.fintech.exception;



public class EntityNotFoundException extends Exception {
    public EntityNotFoundException() {}
    public EntityNotFoundException(String message) {
        super(message);
    }
}
