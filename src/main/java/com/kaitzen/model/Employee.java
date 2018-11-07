package com.kaitzen.model;

import com.kaitzen.utils.Seniority;

import javax.persistence.*;

@Entity
@Table (name = "EMPLEADO")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="ID_EMPLEADO")
    private long id;
    @Column (name ="NOMBRE",nullable = false,length = 50)
    private String name;
    @Column (name ="APELLIDO",nullable = false,length = 50)
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name = "SENIORITY", nullable = false, length = 50)
    private Seniority seniority;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO")
    private Project project;

    public Employee(){}
    public Employee(String name, String lastName, Seniority aSeniority) {
        this.name = name;
        this.lastName = lastName;
        this.seniority = aSeniority;

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