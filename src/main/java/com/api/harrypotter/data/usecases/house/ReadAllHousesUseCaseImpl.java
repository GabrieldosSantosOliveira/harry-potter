package com.api.harrypotter.data.usecases.house;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.gateways.repositories.LoadHousesRepository;
import com.api.harrypotter.domain.usecases.dtos.PageDto;
import com.api.harrypotter.domain.usecases.house.ReadAllHousesUseCase;
import org.springframework.stereotype.Service;

@Service
public class ReadAllHousesUseCaseImpl implements ReadAllHousesUseCase {
    private final LoadHousesRepository loadHousesRepository;

    public ReadAllHousesUseCaseImpl(LoadHousesRepository loadHousesRepository) {
        this.loadHousesRepository = loadHousesRepository;
    }


    @Override
    public PageDto<House> execute(long page, long pageSize) {
        return this.loadHousesRepository.findAll(page, pageSize);
    }
}
