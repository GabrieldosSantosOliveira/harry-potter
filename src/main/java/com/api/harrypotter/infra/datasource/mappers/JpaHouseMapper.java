package com.api.harrypotter.infra.datasource.mappers;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.infra.datasource.models.HouseModel;

public class JpaHouseMapper {
    public static HouseModel toJpa(House house) {
        return new HouseModel(house.id(), house.name(), house.description());

    }

    public static House toDomain(HouseModel houseModel) {
        return new House(houseModel.getId(), houseModel.getName(), houseModel.getDescription());
    }
}
