package com.api.harrypotter.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;

public record Student(UUID id, String name, LocalDateTime dateOfBirth) {
    public int getAge() {
        return Period.between(dateOfBirth.toLocalDate(), LocalDate.now()).getYears();
    }
}
