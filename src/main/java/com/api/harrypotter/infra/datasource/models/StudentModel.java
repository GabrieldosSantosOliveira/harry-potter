package com.api.harrypotter.infra.datasource.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "student")
public class StudentModel implements Serializable {
    @Id
    private UUID id;

    @Column
    private String name;
    @Column
    private LocalDate dateOfBirth;
    @ManyToOne
    private HouseModel houseModel;

    public UUID getId() {
        return id;
    }

    public HouseModel getHouseModel() {
        return houseModel;
    }

    public void setHouseModel(HouseModel houseModel) {
        this.houseModel = houseModel;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(houseModel, that.houseModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, houseModel);
    }

    @Override
    public String toString() {
        return "StudentModel{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", houseModel=" + houseModel +
            '}';
    }
}
