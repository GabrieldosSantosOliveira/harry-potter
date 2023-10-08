package com.api.harrypotter.data.usecases.house;

import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.exceptions.StudentNotFoundException;
import com.api.harrypotter.domain.gateways.repositories.LoadStudentByIdRepository;
import com.api.harrypotter.domain.usecases.student.ReadStudentUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReadStudentUseCaseImpl implements ReadStudentUseCase {

    public final LoadStudentByIdRepository loadStudentByIdRepository;

    public ReadStudentUseCaseImpl(LoadStudentByIdRepository loadStudentByIdRepository) {
        this.loadStudentByIdRepository = loadStudentByIdRepository;
    }

    @Override
    public Student execute(UUID id) {
        Optional<Student> studentExists = this.loadStudentByIdRepository.findById(id);
        if (studentExists.isEmpty()) {
            throw new StudentNotFoundException();
        }
        return studentExists.get();
    }
}
