package com.api.harrypotter.infra.datasource.jpa;

import com.api.harrypotter.infra.datasource.models.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaHouseRepository extends JpaRepository<HouseModel, UUID> {
   public Optional<HouseModel> findByName(String id);
}
