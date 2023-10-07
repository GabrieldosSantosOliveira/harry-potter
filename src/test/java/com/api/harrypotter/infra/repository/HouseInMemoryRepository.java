package com.api.harrypotter.infra.repository;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.gateways.repositories.CreateHouseRepository;
import com.api.harrypotter.domain.gateways.repositories.LoadHouseByNameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class HouseInMemoryRepository implements CreateHouseRepository, LoadHouseByNameRepository {
    private final List<House> houses = new ArrayList<House>();

    @Override
    public void create(House house) {
        this.houses.add(house);
    }

    @Override
    public Optional<House> findByName(String name) {
        return this.houses.stream().filter((house) -> Objects.equals(house.name(), name)).findFirst();
    }
}
