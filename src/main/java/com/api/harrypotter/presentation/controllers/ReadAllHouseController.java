package com.api.harrypotter.presentation.controllers;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.usecases.dtos.PageDto;
import com.api.harrypotter.domain.usecases.house.ReadAllHousesUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/house")
public class ReadAllHouseController {
    private final ReadAllHousesUseCase readAllHousesUseCase;

    public ReadAllHouseController(ReadAllHousesUseCase readAllHousesUseCase) {
        this.readAllHousesUseCase = readAllHousesUseCase;
    }

    @GetMapping
    public ResponseEntity<Object> execute(@RequestParam(required = false, defaultValue = "0") String page, @RequestParam(required = false, defaultValue = "10") String pageSize) {
        PageDto<House> pageDto = this.readAllHousesUseCase.execute(Long.parseLong(page), Long.parseLong(pageSize));
        return ResponseEntity.status(HttpStatus.OK).body(pageDto);
    }
}
