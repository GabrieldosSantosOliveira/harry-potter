package com.api.harrypotter.domain.usecases.house;

import com.api.harrypotter.domain.entities.House;

public interface CreateHouseUseCase {
    public House execute(String name, String description);
}
