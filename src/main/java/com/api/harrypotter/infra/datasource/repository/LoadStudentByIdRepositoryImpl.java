package com.api.harrypotter.infra.datasource.repository;

import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.gateways.repositories.LoadStudentByIdRepository;
import com.api.harrypotter.infra.datasource.jpa.JpaStudentRepository;
import com.api.harrypotter.infra.datasource.mappers.JpaStudentMapper;
import com.api.harrypotter.infra.datasource.models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class LoadStudentByIdRepositoryImpl implements LoadStudentByIdRepository {

    @Autowired
    public JpaStudentRepository jpaStudentRepository;

    @Override
    public Optional<Student> findById(UUID id) {
        Optional<StudentModel> studentExists = jpaStudentRepository.findById(id);
        return studentExists.map(JpaStudentMapper::toDomain);
    }
}
