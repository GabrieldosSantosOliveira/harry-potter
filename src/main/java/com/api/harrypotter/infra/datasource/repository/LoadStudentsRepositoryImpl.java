package com.api.harrypotter.infra.datasource.repository;

import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.gateways.repositories.LoadStudentsRepository;
import com.api.harrypotter.domain.usecases.dtos.PageDto;
import com.api.harrypotter.domain.usecases.dtos.PageInfoDto;
import com.api.harrypotter.infra.datasource.jpa.JpaStudentRepository;
import com.api.harrypotter.infra.datasource.mappers.JpaStudentMapper;
import com.api.harrypotter.infra.datasource.models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoadStudentsRepositoryImpl implements LoadStudentsRepository {
    @Autowired
    private JpaStudentRepository jpaStudentRepository;

    @Override
    public PageDto<Student> findAll(long page, long pageSize) {
        Pageable pageable = PageRequest.of((int) page, (int) pageSize);
        Page<StudentModel> rawPage = this.jpaStudentRepository.findAll(pageable);
        List<Student> data = rawPage.getContent().stream().map(JpaStudentMapper::toDomain).toList();
        boolean hasNext = page + 1 < rawPage.getTotalPages();
        boolean hasPrev = rawPage.getTotalPages() >= page + 1 && page > 0;
        PageInfoDto pageInfoDto = new PageInfoDto(
            rawPage.getTotalElements(),
            rawPage.getTotalPages(),
            hasNext, hasPrev
        );
        return new PageDto<Student>(data, pageInfoDto);
    }
}
