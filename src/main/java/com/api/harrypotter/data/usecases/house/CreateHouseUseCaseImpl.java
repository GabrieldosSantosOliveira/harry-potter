package com.api.harrypotter.data.usecases.house;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.exceptions.HouseAlreadyExistsException;
import com.api.harrypotter.domain.gateways.repositories.CreateHouseRepository;
import com.api.harrypotter.domain.gateways.repositories.LoadHouseByNameRepository;
import com.api.harrypotter.domain.usecases.house.CreateHouseUseCase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreateHouseUseCaseImpl implements CreateHouseUseCase {
    private final LoadHouseByNameRepository loadHouseByNameRepository;
    private final CreateHouseRepository createHouseRepository;

    public CreateHouseUseCaseImpl(LoadHouseByNameRepository loadHouseByNameRepository, CreateHouseRepository createHouseRepository) {
        this.loadHouseByNameRepository = loadHouseByNameRepository;
        this.createHouseRepository = createHouseRepository;
    }

    @Override
    public House execute(String name, String description) {
        Optional<House> isHouseAlreadyExists = this.loadHouseByNameRepository.findByName(name);
        if (isHouseAlreadyExists.isPresent()) {
            throw new HouseAlreadyExistsException();
        }
        House house = new House(UUID.randomUUID(), name, description);
        this.createHouseRepository.create(house);
        return house;
    }
}
