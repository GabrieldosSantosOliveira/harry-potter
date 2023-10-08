package com.api.harrypotter.presentation.controllers;

import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.usecases.dtos.PageDto;
import com.api.harrypotter.domain.usecases.student.ReadAllStudentsUseCase;
import com.api.harrypotter.presentation.dtos.student.StudentResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class ReadAllStudentsController {
    public final ReadAllStudentsUseCase readAllStudentsUseCase;

    public ReadAllStudentsController(ReadAllStudentsUseCase readAllStudentsUseCase) {
        this.readAllStudentsUseCase = readAllStudentsUseCase;
    }

    @GetMapping
    public ResponseEntity<PageDto<StudentResponseDto>> execute(@RequestParam(required = false, defaultValue = "0") String page, @RequestParam(required = false, defaultValue = "10") String pageSize) {
        PageDto<Student> students = this.readAllStudentsUseCase.execute(Long.parseLong(page), Long.parseLong(pageSize));
        return ResponseEntity.status(HttpStatus.OK).body(new PageDto<>(students.data().stream().map(StudentResponseDto::fromDomain).toList(), students.info()));
    }

}
