package com.api.harrypotter.domain.usecases.house;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.usecases.dtos.PageDto;

import java.util.List;

public interface ReadAllHousesUseCase {
    public PageDto<House> execute(long page, long pageSize);
}
