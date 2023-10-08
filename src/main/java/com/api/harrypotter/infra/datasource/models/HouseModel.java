package com.api.harrypotter.infra.datasource.models;

import com.api.harrypotter.domain.entities.Student;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "house")
public class HouseModel implements Serializable {

    public HouseModel() {
    }

    public HouseModel(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Id
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToMany(
        mappedBy = "houseModel"
    )
    private List<StudentModel> studentModels;

    public List<StudentModel> getStudentModels() {
        return studentModels;
    }

    public void setStudentModels(List<StudentModel> studentModels) {
        this.studentModels = studentModels;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseModel that = (HouseModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(studentModels, that.studentModels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, studentModels);
    }

    @Override
    public String toString() {
        return "HouseModel{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", studentModels=" + studentModels +
            '}';
    }
}
