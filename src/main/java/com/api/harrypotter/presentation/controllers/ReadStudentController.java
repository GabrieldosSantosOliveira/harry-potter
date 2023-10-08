package com.api.harrypotter.presentation.controllers;

import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.usecases.student.ReadStudentUseCase;
import com.api.harrypotter.presentation.dtos.student.StudentResponseDto;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/student")
public class ReadStudentController {
    public ReadStudentUseCase readStudentUseCase;

    public ReadStudentController(ReadStudentUseCase readStudentUseCase) {
        this.readStudentUseCase = readStudentUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> execute(@PathVariable(value = "id") @Validated @NotBlank UUID id) {
        Student student = this.readStudentUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(StudentResponseDto.fromDomain(student));
    }
}
