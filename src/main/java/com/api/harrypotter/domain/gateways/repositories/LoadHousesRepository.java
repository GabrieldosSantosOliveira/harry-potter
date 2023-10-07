package com.api.harrypotter.domain.gateways.repositories;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.usecases.dtos.PageDto;


public interface LoadHousesRepository {
    public PageDto<House> findAll(long page, long pageSize);
}
