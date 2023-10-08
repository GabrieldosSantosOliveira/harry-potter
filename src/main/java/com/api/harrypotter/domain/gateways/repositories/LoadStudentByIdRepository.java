package com.api.harrypotter.domain.gateways.repositories;

import com.api.harrypotter.domain.entities.Student;

import java.util.Optional;
import java.util.UUID;

public interface LoadStudentByIdRepository {
    public Optional<Student> findById(UUID id);
}
