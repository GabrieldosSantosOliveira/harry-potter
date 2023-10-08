package com.api.harrypotter.presentation.dtos.student;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.entities.Student;

import java.time.LocalDate;
import java.util.UUID;

public record StudentResponseDto(UUID id, String name, LocalDate dateOfBirth, House house) {
    public static StudentResponseDto fromDomain(Student student) {
        return new StudentResponseDto(
            student.id(),
            student.name(),
            student.dateOfBirth(),
            student.house()
        );
    }

}
