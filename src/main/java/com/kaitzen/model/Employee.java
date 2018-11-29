package com.kaitzen.model;

import com.kaitzen.utils.Seniority;

import javax.persistence.*;

@Entity
@Table(name = "EMPLEADOS")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private long id;

    @Column(name = "NOMBRE",nullable = false, length = 50)
    private String name;

    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String lastName;


    @Enumerated(EnumType.STRING)
    @Column(name = "JERARQUIA", nullable = false, length = 50)
    private Seniority seniority;


    @ManyToOne
    @JoinColumn(name = "PROJECTO")
    private Project project;

    public Employee(){

    }

    public Employee(String name, String lastname, Seniority seniority,Project project){

        this.name = name;
        this.lastName = lastname;
        this.seniority = seniority;
        this.project = project;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }



}
