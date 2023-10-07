package com.api.harrypotter.domain.usecases.dtos;

import java.util.List;

public record PageDto<T>(List<T> data, PageInfoDto info) {
}
