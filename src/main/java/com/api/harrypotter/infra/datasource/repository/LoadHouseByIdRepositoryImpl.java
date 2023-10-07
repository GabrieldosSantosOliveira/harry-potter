package com.api.harrypotter.infra.datasource.repository;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.gateways.repositories.LoadHouseByIdRepository;
import com.api.harrypotter.infra.datasource.jpa.JpaHouseRepository;
import com.api.harrypotter.infra.datasource.mappers.JpaHouseMapper;
import com.api.harrypotter.infra.datasource.models.HouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class LoadHouseByIdRepositoryImpl implements LoadHouseByIdRepository {

    @Autowired
    private JpaHouseRepository jpaHouseRepository;

    @Override
    public Optional<House> findById(UUID id) {
        Optional<HouseModel> rawHouse = this.jpaHouseRepository.findById(id);
        return rawHouse.map(JpaHouseMapper::toDomain);
    }
}
