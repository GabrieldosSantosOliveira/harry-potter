package com.api.harrypotter.domain.exceptions;

public class HouseAlreadyExistsException extends RuntimeException {
    public HouseAlreadyExistsException() {
        super("House already exists");
    }
}
