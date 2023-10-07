package com.api.harrypotter.presentation.exceptions.house;

import com.api.harrypotter.domain.exceptions.HouseNotFoundException;
import com.api.harrypotter.presentation.dtos.exceptions.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HouseNotFoundExceptionHandler {
    @ExceptionHandler(value = HouseNotFoundException.class)
    public ResponseEntity<ExceptionDto> execute(HouseNotFoundException houseNotFoundException) {
        ExceptionDto exceptionDto = new ExceptionDto(houseNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }
}
