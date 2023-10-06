package com.api.harrypotter.presentation.dtos.house;

import com.api.harrypotter.domain.entities.House;

import java.util.UUID;

public record HouseResponseDto(
        UUID id,
        String name,
        String description
) {
    public static HouseResponseDto fromDomain(House house) {
        return new HouseResponseDto(
                house.id(),
                house.name(),
                house.description()
        );
    }
}
