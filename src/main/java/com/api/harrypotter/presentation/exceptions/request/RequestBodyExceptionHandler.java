package com.api.harrypotter.presentation.exceptions.request;

import com.api.harrypotter.presentation.dtos.exceptions.ExceptionBadRequestDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class RequestBodyExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionBadRequestDto> execute(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        ExceptionBadRequestDto exceptionBadRequestDto = new ExceptionBadRequestDto(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionBadRequestDto);
    }
}
