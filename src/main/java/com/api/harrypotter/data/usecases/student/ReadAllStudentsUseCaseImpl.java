package com.api.harrypotter.data.usecases.student;

import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.gateways.repositories.LoadStudentsRepository;
import com.api.harrypotter.domain.usecases.dtos.PageDto;
import com.api.harrypotter.domain.usecases.student.ReadAllStudentsUseCase;
import org.springframework.stereotype.Service;

@Service
public class ReadAllStudentsUseCaseImpl implements ReadAllStudentsUseCase {
    public final LoadStudentsRepository loadStudentsRepository;

    public ReadAllStudentsUseCaseImpl(LoadStudentsRepository loadStudentsRepository) {
        this.loadStudentsRepository = loadStudentsRepository;
    }

    @Override
    public PageDto<Student> execute(long page, long pageSize) {
        return this.loadStudentsRepository.findAll(page, pageSize);
    }
}
