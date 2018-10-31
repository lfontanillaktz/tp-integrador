package com.kaitzen.model;

import com.kaitzen.utils.Seniority;

import javax.persistence.*;

@Entity
@Table(name="Empleado")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name="Nombre",length = 50,nullable = false)
    private String name;

    @Column(name="Apellido",length = 50,nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Senioria", nullable = false)
    private Seniority seniority;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO")
    private Project project;

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

    public Employee(){}

    public Employee(String name, String apellido, Seniority seniority, Project projecto) {
        this.name = name;
        this.lastName = apellido;
        this.seniority=seniority;
        this.project=projecto;
    }


}
