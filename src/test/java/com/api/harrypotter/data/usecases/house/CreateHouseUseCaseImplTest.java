package com.api.harrypotter.data.usecases.house;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.exceptions.HouseAlreadyExistsException;
import com.api.harrypotter.infra.repository.HouseInMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CreateHouseUseCaseImplTest {
    public CreateHouseUseCaseImpl createHouseUseCaseImpl;
    public HouseInMemoryRepository houseInMemoryRepository;

    @BeforeEach
    public void setup() {
        this.houseInMemoryRepository = new HouseInMemoryRepository();
        this.createHouseUseCaseImpl = new CreateHouseUseCaseImpl(this.houseInMemoryRepository, this.houseInMemoryRepository);
    }

    @Test
    public void shouldCreateHouseIfSuccess() {
        House house = this.createHouseUseCaseImpl.execute("any_name", "any_description");
        assertNotNull(house);
        assertEquals(house.description(), "any_description");
        assertEquals(house.name(), "any_name");
    }

    @Test
    public void shouldThrowExceptionIfHouseAlreadyExists() {
        this.insertOneHouse("any_name", "any_description");
        assertThrowsExactly(HouseAlreadyExistsException.class, () -> {
            this.createHouseUseCaseImpl.execute("any_name", "any_description");
        });
    }

    public void insertOneHouse(String name, String description) {
        House house = new House(UUID.randomUUID(), name, description);
        this.houseInMemoryRepository.create(house);
    }

}