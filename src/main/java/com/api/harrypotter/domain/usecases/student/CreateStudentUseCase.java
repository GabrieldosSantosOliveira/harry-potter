package com.api.harrypotter.domain.usecases.student;

import com.api.harrypotter.domain.entities.Student;

import java.time.LocalDate;
import java.util.UUID;

public interface CreateStudentUseCase {
    public Student execute(String name, LocalDate dateOfBirth, UUID houseId);
}
