package org.generation.italy.departementEmployees.model.entities;

import java.time.LocalDate;

public class Employee {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate hireDate;
    private Sex sex;
    private Department department;

    public Employee(long id, String firstname, String lastname, LocalDate hireDate, Sex sex) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hireDate = hireDate;
        this.sex = sex;
    }

    public Employee(long id, String firstname, String lastname, LocalDate hireDate, Sex sex, Department department) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hireDate = hireDate;
        this.sex = sex;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
