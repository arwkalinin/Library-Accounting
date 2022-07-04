package com.arwka.libraryacc.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int id;
    @NotEmpty(message = "Full name should not be empty.")
    @Size(min = 5, max = 64, message = "Full name should be between 5 and 64 characters.")
    private String name;
    @Min(value = 1900, message = "Year of birth should be greater than 1900.")
    @Max(value = 2022, message = "Year of birth should be less than 2023.")
    private int birth;

    public Person() {}
    public Person(String fullName, int yearOfBirth) {
        this.name = fullName;
        this.birth = yearOfBirth;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBirth() {
        return birth;
    }
    public void setBirth(int birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
