package com.api.harrypotter.domain.usecases.dtos;

public record PageInfoDto(long count, long pages, boolean hasNext, boolean hasPrev) {
}
