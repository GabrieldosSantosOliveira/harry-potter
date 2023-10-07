package com.api.harrypotter.domain.usecases.house;

import com.api.harrypotter.domain.entities.House;

import java.util.UUID;

public interface ReadHouseUseCase {
   public House execute(UUID id);
}
