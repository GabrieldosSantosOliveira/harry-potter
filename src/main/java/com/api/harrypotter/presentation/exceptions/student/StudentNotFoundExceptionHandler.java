package com.api.harrypotter.presentation.exceptions.student;

import com.api.harrypotter.domain.exceptions.StudentNotFoundException;
import com.api.harrypotter.presentation.dtos.exceptions.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentNotFoundExceptionHandler {
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<ExceptionDto> execute(StudentNotFoundException studentNotFoundException) {
        ExceptionDto exceptionDto = new ExceptionDto(
            studentNotFoundException.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);

    }
}
