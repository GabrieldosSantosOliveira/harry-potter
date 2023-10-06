package com.api.harrypotter.domain.gateways.repositories;

import com.api.harrypotter.domain.entities.House;

public interface CreateHouseRepository {
   public void create(House house);
}
