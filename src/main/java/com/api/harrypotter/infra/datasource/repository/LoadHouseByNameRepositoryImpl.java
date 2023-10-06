package com.api.harrypotter.infra.datasource.repository;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.gateways.repositories.LoadHouseByNameRepository;
import com.api.harrypotter.infra.datasource.jpa.JpaHouseRepository;
import com.api.harrypotter.infra.datasource.mappers.JpaHouseMapper;
import com.api.harrypotter.infra.datasource.models.HouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class LoadHouseByNameRepositoryImpl implements LoadHouseByNameRepository {
    @Autowired
    JpaHouseRepository jpaHouseRepository;

    @Override
    public Optional<House> findByName(String name) {
        Optional<HouseModel> rawHouse = this.jpaHouseRepository.findByName(name);
        return rawHouse.map(JpaHouseMapper::toDomain);
    }
}
