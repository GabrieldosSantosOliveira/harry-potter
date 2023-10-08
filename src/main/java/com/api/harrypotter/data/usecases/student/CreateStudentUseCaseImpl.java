package com.api.harrypotter.data.usecases.student;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.exceptions.HouseNotFoundException;
import com.api.harrypotter.domain.gateways.repositories.CreateStudentRepository;
import com.api.harrypotter.domain.gateways.repositories.LoadHouseByIdRepository;
import com.api.harrypotter.domain.usecases.student.CreateStudentUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {
    private final CreateStudentRepository createStudentRepository;
    private final LoadHouseByIdRepository loadHouseByIdRepository;

    public CreateStudentUseCaseImpl(CreateStudentRepository createStudentRepository, LoadHouseByIdRepository loadHouseByIdRepository) {
        this.createStudentRepository = createStudentRepository;
        this.loadHouseByIdRepository = loadHouseByIdRepository;
    }

    @Override
    public Student execute(String name, LocalDate dateOfBirth, UUID houseId) {
        Optional<House> isHouseExists = this.loadHouseByIdRepository.findById(houseId);
        if (isHouseExists.isEmpty()) {
            throw new HouseNotFoundException();
        }
        Student student = new Student(UUID.randomUUID(), name, dateOfBirth, isHouseExists.get());
        this.createStudentRepository.create(student, isHouseExists.get());
        return student;
    }
}
