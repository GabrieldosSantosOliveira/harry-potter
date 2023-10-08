package com.api.harrypotter.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public record Student(UUID id, String name, LocalDate dateOfBirth, House house) implements Serializable {
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
