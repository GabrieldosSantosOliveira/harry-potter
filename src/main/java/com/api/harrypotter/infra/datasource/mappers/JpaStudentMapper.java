package com.api.harrypotter.infra.datasource.mappers;

import com.api.harrypotter.domain.entities.House;
import com.api.harrypotter.domain.entities.Student;
import com.api.harrypotter.infra.datasource.models.HouseModel;
import com.api.harrypotter.infra.datasource.models.StudentModel;

public class JpaStudentMapper {
    public static StudentModel toJpa(Student student, House house) {
        StudentModel studentModel = new StudentModel();
        studentModel.setName(student.name());
        studentModel.setDateOfBirth(student.dateOfBirth());
        studentModel.setId(student.id());
        HouseModel houseModel = JpaHouseMapper.toJpa(house);
        studentModel.setHouseModel(houseModel);
        return studentModel;
    }

    public static StudentModel toJpa(Student student) {
        StudentModel studentModel = new StudentModel();
        studentModel.setDateOfBirth(student.dateOfBirth());
        studentModel.setId(student.id());
        return studentModel;
    }

    public static Student toDomain(StudentModel studentModel) {
        return new Student(studentModel.getId(), studentModel.getName(), studentModel.getDateOfBirth(), JpaHouseMapper.toDomain(studentModel.getHouseModel()));
    }

}
