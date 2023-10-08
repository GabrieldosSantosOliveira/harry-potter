package com.api.harrypotter.infra.datasource.jpa;

import com.api.harrypotter.infra.datasource.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaStudentRepository extends JpaRepository<StudentModel, UUID> {
}
