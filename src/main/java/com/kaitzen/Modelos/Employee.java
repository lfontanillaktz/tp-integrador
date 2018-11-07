package com.kaitzen.Modelos;

import com.kaitzen.utils.Seniority;

import javax.persistence.*;

@Entity
@Table(name = "EMPLEADO")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String name;

    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "SENIORITY", nullable = false)
    private Seniority seniority;

    @JoinColumn(name = "ID_PROYECTO", nullable = false)
    @ManyToOne
    private Project project;

    public Employee() {
    }

    public Employee(String name, String lastName, Seniority seniority, Project project) {
        this.name = name;
        this.lastName = lastName;
        this.seniority = seniority;
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    public Project getProject() {
        return project;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
