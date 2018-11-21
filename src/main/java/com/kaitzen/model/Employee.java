package com.kaitzen.model;

import com.kaitzen.utils.Seniority;

import javax.persistence.*;


@Entity
@Table(name="EMPLEADO")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NOMBRE",nullable = false,length = 50)
    private String name;

    @Column(name="APELLIDO",nullable = false,length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "JERARQUIA",nullable = false)
    private Seniority seniority;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO")
    private Project project;

    public Employee(){}

    public Employee(String name, String lastName, Seniority seniority, Project project) {
        this.name = name;
        this.lastName = lastName;
        this.seniority = seniority;
        this.project = project;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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



}
