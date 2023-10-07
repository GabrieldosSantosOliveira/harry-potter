package com.api.harrypotter.presentation.controllers;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.usecases.house.CreateHouseUseCase;
import com.api.harrypotter.presentation.dtos.house.HouseRequestDto;
import com.api.harrypotter.presentation.dtos.house.HouseResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/house")
public class CreateHouseController {
    private final CreateHouseUseCase createHouseUseCase;

    public CreateHouseController(CreateHouseUseCase createHouseUseCase) {
        this.createHouseUseCase = createHouseUseCase;

    }

    @PostMapping
    public ResponseEntity<HouseResponseDto> createHouse(@RequestBody @Valid HouseRequestDto houseRequestDto) {
        House house = this.createHouseUseCase.execute(houseRequestDto.name(), houseRequestDto.description());
        return ResponseEntity.status(HttpStatus.CREATED).body(HouseResponseDto.fromDomain(house));
    }

}
