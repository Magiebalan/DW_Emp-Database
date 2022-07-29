package com.demo.emp.entity;

import org.springframework.boot.convert.DurationFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class EmpClass {

    @Id
    private int id;
    private String name;
    private int salary;
    private String designation;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public EmpClass(int id, String name, int salary, String designation) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }

    public EmpClass() {
        super();
    }


}
