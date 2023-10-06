package com.api.harrypotter.presentation.dtos.exceptions;

import java.util.List;

public record ExceptionBadRequestDto(List<String> errors) {
}
