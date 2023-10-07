package com.api.harrypotter.presentation.controllers;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.usecases.house.ReadHouseUseCase;
import com.api.harrypotter.presentation.dtos.house.HouseResponseDto;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("/house")
public class ReadHouseController {
    private final ReadHouseUseCase readHouseUseCase;

    public ReadHouseController(ReadHouseUseCase readHouseUseCase) {
        this.readHouseUseCase = readHouseUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseResponseDto> getHouseById(@PathVariable(value = "id") @Validated @NotBlank UUID id) {
        House house = this.readHouseUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(HouseResponseDto.fromDomain(house));
    }
}
