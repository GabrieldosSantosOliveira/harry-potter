package com.api.harrypotter.presentation.dtos.house;

import jakarta.validation.constraints.NotBlank;

public record HouseRequestDto(
        @NotBlank(message = "The name is required") String name,
        @NotBlank(message = "The description is required") String description
) {
}
