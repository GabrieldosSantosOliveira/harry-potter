package com.api.harrypotter.domain.gateways.repositories;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.entities.Student;

public interface CreateStudentRepository {
    public void create(Student student, House house);
}
