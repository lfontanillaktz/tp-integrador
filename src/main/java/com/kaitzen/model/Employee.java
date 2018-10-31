package com.kaitzen.model;

import com.kaitzen.utils.Seniority;

import javax.persistence.*;

@Entity
@Table(name="Empleado")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="NOMBRE",nullable = false, length = 50)
    private String name;

    @Column(name="APELLIDO",nullable = false, length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name= "JERARQUIA",nullable = false, length = 50)
    private Seniority seniority;

    @ManyToOne
    @JoinColumn(name="PROYECTO_ACTUAL")
    private Project project;


    public Employee(){}

    public Employee(String name, String lastName, Seniority seniority, Project project) {
        this.name = name;
        this.lastName = lastName;
        this.seniority = seniority;
        this.project = project;
    }
}




