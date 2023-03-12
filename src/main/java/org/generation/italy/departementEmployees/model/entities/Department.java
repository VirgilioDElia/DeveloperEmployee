package org.generation.italy.departementEmployees.model.entities;

import java.util.Set;

public class Department {
    private long id;
    private String name;
    private String Address;
    private int maxCapacity;
    private Set<Employee> employeeSet;
    public Department(long id, String name, String address, int maxCapacity) {
        this.id = id;
        this.name = name;
        Address = address;
        this.maxCapacity = maxCapacity;
    }

    public Department(long id, String name, String address, int maxCapacity, Set<Employee> employeeSet) {
        this.id = id;
        this.name = name;
        Address = address;
        this.maxCapacity = maxCapacity;
        this.employeeSet = employeeSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
