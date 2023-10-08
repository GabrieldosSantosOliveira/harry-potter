package com.api.harrypotter.domain.gateways.repositories;

import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.usecases.dtos.PageDto;

public interface LoadStudentsRepository {
    public PageDto<Student> findAll(long page, long pageSize);
}
