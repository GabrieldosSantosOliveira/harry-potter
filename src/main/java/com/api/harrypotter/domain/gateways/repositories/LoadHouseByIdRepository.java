package com.api.harrypotter.domain.gateways.repositories;

import com.api.harrypotter.domain.entities.House;

import java.util.Optional;
import java.util.UUID;

public interface LoadHouseByIdRepository {
   public Optional<House> findById(UUID id);
}
