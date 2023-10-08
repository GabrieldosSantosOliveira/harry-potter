package com.api.harrypotter.infra.datasource.repository;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.domain.gateways.repositories.CreateStudentRepository;
import com.api.harrypotter.infra.datasource.jpa.JpaStudentRepository;

import com.api.harrypotter.infra.datasource.mappers.JpaStudentMapper;
import com.api.harrypotter.infra.datasource.models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreateStudentRepositoryImpl implements CreateStudentRepository {
    @Autowired
    private JpaStudentRepository jpaStudentRepository;
    @Override
    public void create(Student student, House house) {
        StudentModel studentModel = JpaStudentMapper.toJpa(student, house);
        this.jpaStudentRepository.save(studentModel);
    }
}
