package com.api.harrypotter.presentation.controllers;

import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.usecases.student.CreateStudentUseCase;
import com.api.harrypotter.presentation.dtos.student.StudentRequestDto;
import com.api.harrypotter.presentation.dtos.student.StudentResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class CreateStudentController {
    private final CreateStudentUseCase createStudentUseCase;

    public CreateStudentController(CreateStudentUseCase createStudentUseCase) {
        this.createStudentUseCase = createStudentUseCase;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(@RequestBody @Valid StudentRequestDto studentDto) {
        Student student = this.createStudentUseCase.execute(studentDto.name(), LocalDate
            .parse(studentDto.dateOfBirth()), UUID.fromString(studentDto.houseId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentResponseDto.fromDomain(student));
    }
}
