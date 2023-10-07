package com.api.harrypotter.domain.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    public void shouldCreateStudentWithCorrectName() {
        Student student = this.makeSut();
        assertEquals("any_name", student.name());
    }

    @Test
    public void shouldCreateStudentWithCorrectDateOfBirth() {
        Student student = this.makeSut();
        LocalDateTime dateOfBirth = LocalDateTime.of(2004, 5, 12, 10, 10);
        assertEquals(dateOfBirth, student.dateOfBirth());
    }

    @Test
    public void shouldCalculateCorrectAge() {
        Student student = this.makeSut();
        LocalDateTime dateOfBirth = LocalDateTime.of(2004, 5, 12, 10, 10);
        int age = Period.between(dateOfBirth.toLocalDate(), LocalDate.now()).getYears();
        assertEquals(age, student.getAge());
    }

    public Student makeSut() {
        LocalDateTime dateOfBirth = LocalDateTime.of(2004, 5, 12, 10, 10);
        return new Student(UUID.randomUUID(), "any_name", dateOfBirth);
    }

}
