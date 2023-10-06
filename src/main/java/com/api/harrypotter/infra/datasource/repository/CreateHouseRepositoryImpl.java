package com.api.harrypotter.infra.datasource.repository;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.gateways.repositories.CreateHouseRepository;
import com.api.harrypotter.infra.datasource.jpa.JpaHouseRepository;
import com.api.harrypotter.infra.datasource.mappers.JpaHouseMapper;
import com.api.harrypotter.infra.datasource.models.HouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreateHouseRepositoryImpl implements CreateHouseRepository {
    @Autowired
    JpaHouseRepository jpaHouseRepository;

    @Override
    public void create(House house) {
        HouseModel rawHouseModel = JpaHouseMapper.toJpa(house);
        this.jpaHouseRepository.save(rawHouseModel);
    }
}
