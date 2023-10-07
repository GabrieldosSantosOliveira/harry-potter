package com.api.harrypotter.presentation.controllers;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.gateways.repositories.CreateHouseRepository;
import com.api.harrypotter.infra.datasource.jpa.JpaHouseRepository;
import com.api.harrypotter.presentation.dtos.house.HouseRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class HouseControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private static ObjectMapper objectMapper;

    @Autowired
    private CreateHouseRepository createHouseRepository;
    @Autowired
    private JpaHouseRepository jpaHouseRepository;
    private String url = "/house";

    @BeforeAll
    public static void init() {
        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    public void setup() {
        this.jpaHouseRepository.deleteAll();
    }
    @AfterEach
    public void tearDown(){
        this.jpaHouseRepository.deleteAll();
    }


    @Description("should return badRequest if name is not provided")
    @Test
    public void shouldReturnBadRequestIfNameIsNotProvided() throws Exception {
        HouseRequestDto houseRequest = new HouseRequestDto(null, "any_description");
        String request = objectMapper.writeValueAsString(houseRequest);
        this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(request))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Description("should return badRequest if description is not provided")
    @Test
    public void shouldReturnBadRequestIfDescriptionIsNotProvided() throws Exception {
        HouseRequestDto houseRequest = new HouseRequestDto("any_name", null);
        String request = objectMapper.writeValueAsString(houseRequest);

        this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(request))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Description("should return badRequest if description and name is not provided")
    @Test
    public void shouldReturnBadRequestIfDescriptionAndNameIsNotProvided() throws Exception {
        HouseRequestDto houseRequest = new HouseRequestDto(null, null);
        String request = objectMapper.writeValueAsString(houseRequest);
        this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(request))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Description("should return HouseResponseDto if success")
    @Test
    public void shouldReturnHouseIfSuccess() throws Exception {
        String request = objectMapper.writeValueAsString(this.buildHouseRequest());
        this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(request))
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("any_name"))
            .andExpect(jsonPath("$.description").value("any_description"));
    }

    @Description("should return exception if house already exists")
    @Test
    public void shouldReturnExceptionIfHouseAlreadyExists() throws Exception {
        HouseRequestDto houseRequest = this.buildHouseRequest();
        String request = objectMapper.writeValueAsString(houseRequest);
        House house = new House(UUID.randomUUID(), houseRequest.name(), houseRequest.description());
        createHouseRepository.create(house);
        this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(request))
            .andDo(print())
            .andExpect(status().isConflict())
            .andExpect(jsonPath("$.message").value("House already exists"));
    }

    public HouseRequestDto buildHouseRequest() {
        return new HouseRequestDto("any_name", "any_description");
    }
}