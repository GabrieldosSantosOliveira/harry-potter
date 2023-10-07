package com.api.harrypotter.data.usecases.house;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.exceptions.HouseNotFoundException;
import com.api.harrypotter.domain.gateways.repositories.LoadHouseByIdRepository;
import com.api.harrypotter.domain.usecases.house.ReadHouseUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class ReadHouseUseCaseImpl implements ReadHouseUseCase {
    private final LoadHouseByIdRepository loadHouseByIdRepository;

    public ReadHouseUseCaseImpl(LoadHouseByIdRepository loadHouseByIdRepository) {
        this.loadHouseByIdRepository = loadHouseByIdRepository;
    }

    @Override
    public House execute(UUID id) {
        Optional<House> isHouseExists = this.loadHouseByIdRepository.findById(id);

        if (isHouseExists.isEmpty()) {
            throw new HouseNotFoundException();
        }
        return isHouseExists.get();
    }
}
