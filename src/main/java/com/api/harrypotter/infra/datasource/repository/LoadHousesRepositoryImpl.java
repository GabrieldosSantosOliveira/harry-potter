package com.api.harrypotter.infra.datasource.repository;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.gateways.repositories.LoadHousesRepository;
import com.api.harrypotter.domain.usecases.dtos.PageDto;
import com.api.harrypotter.domain.usecases.dtos.PageInfoDto;
import com.api.harrypotter.infra.datasource.jpa.JpaHouseRepository;
import com.api.harrypotter.infra.datasource.mappers.JpaHouseMapper;
import com.api.harrypotter.infra.datasource.models.HouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoadHousesRepositoryImpl implements LoadHousesRepository {
    @Autowired
    private JpaHouseRepository jpaHouseRepository;


    @Override
    public PageDto<House> findAll(long page, long pageSize) {
        Pageable pageable = PageRequest.of((int) page, (int) pageSize);
        Page<HouseModel> rawPage = this.jpaHouseRepository.findAll(pageable);
        List<House> data = rawPage.getContent().stream().map(JpaHouseMapper::toDomain).toList();
        boolean hasNext = page + 1 < rawPage.getTotalPages();
        boolean hasPrev = rawPage.getTotalPages() >= page + 1 && page > 0;
        PageInfoDto pageInfoDto = new PageInfoDto(
            rawPage.getTotalElements(),
            rawPage.getTotalPages(),
            hasNext, hasPrev
        );
        return new PageDto<House>(data, pageInfoDto);
    }
}
