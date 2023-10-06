package com.api.harrypotter.domain.gateways.repositories;

import com.api.harrypotter.domain.entities.House;

import java.util.Optional;

public interface LoadHouseByNameRepository {
  public Optional<House> findByName(String name);
}
