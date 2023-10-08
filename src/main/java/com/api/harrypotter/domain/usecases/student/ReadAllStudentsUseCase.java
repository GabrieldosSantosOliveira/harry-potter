package com.api.harrypotter.domain.usecases.student;

import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.usecases.dtos.PageDto;


public interface ReadAllStudentsUseCase {
    public PageDto<Student> execute(long page, long pageSize);
}
