package com.arwka.libraryacc.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int id;
    @NotEmpty(message = "Full name should not be empty.")
    @Size(min = 5, max = 64, message = "Full name should be between 5 and 64 characters.")
    private String fullName;
    @Min(value = 1900, message = "Year of birth should be greater than 1900.")
    @Max(value = 2022, message = "Year of birth should be less than 2023.")
    private int yearOfBirth;

    ///////////////////
    public Person() {}
    public Person(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }
    //
    public int getId() {
        return id;
    }
    //
    public void setId(int id) {
        this.id = id;
    }
    //
    public String getFullName() {
        return fullName;
    }
    //
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    //
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    //
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    //
    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
