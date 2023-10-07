package com.api.harrypotter.domain.exceptions;

public class HouseNotFoundException extends RuntimeException {
    public HouseNotFoundException() {
        super("House not found");
    }
}
