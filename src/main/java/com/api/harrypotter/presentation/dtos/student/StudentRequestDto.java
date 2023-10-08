package com.api.harrypotter.presentation.dtos.student;

import jakarta.validation.constraints.NotBlank;


public record StudentRequestDto(
    @NotBlank String name,
    @NotBlank String dateOfBirth,
    @NotBlank String houseId
) {
}
