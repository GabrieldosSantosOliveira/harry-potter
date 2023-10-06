package com.api.harrypotter.presentation.exceptions.house;

import com.api.harrypotter.domain.exceptions.HouseAlreadyExistsException;
import com.api.harrypotter.presentation.dtos.exceptions.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HouseAlreadyExistsExceptionHandler {
    @ExceptionHandler(value = HouseAlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> execute(HouseAlreadyExistsException houseAlreadyExistsException){
        ExceptionDto exceptionDto = new ExceptionDto(houseAlreadyExistsException.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDto);
    }
}
