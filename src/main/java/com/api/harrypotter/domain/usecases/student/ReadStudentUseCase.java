package com.api.harrypotter.domain.usecases.student;

import com.api.harrypotter.domain.entities.Student;

import java.util.UUID;

public interface ReadStudentUseCase {
    public Student execute(UUID id);
}
