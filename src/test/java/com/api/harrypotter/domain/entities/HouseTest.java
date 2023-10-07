package com.api.harrypotter.domain.entities;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class HouseTest {
    @Test
    public void shouldCreateHouseWithCorrectName() {
        House house = this.makeSut();
        assertEquals("any_name", house.name());
    }

    @Test
    public void shouldCreateHouseWithCorrectDescription() {
        House house = this.makeSut();
        assertEquals("any_description", house.description());
    }

    public House makeSut() {
        return new House(UUID.randomUUID(), "any_name", "any_description");
    }
}
