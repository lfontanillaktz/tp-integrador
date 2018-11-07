package com.kaitzen.model;

import com.kaitzen.utils.Seniority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "EMPLEADO")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String name;

    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "SENIORITY", nullable = false, length = 50)
    private Seniority seniority;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO")
    private Project project;

    public Employee(String name, String lastName, Seniority seniority) {
        this.name = name;
        this.lastName = lastName;
        this.seniority = seniority;
    }

    public Employee(){};

    public Employee(String name, String lastName, Seniority seniority, Project project) {
        this.name = name;
        this.lastName = lastName;
        this.seniority = seniority;
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

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append("Id: ");
        str.append(id);
        str.append(" Nombre: ");
        str.append(name);
        str.append(" Apellido: ");
        str.append(lastName);
        str.append(" Seniority: ");
        str.append(seniority.name());
        str.append(" Proyecto: ");
        if (Objects.nonNull(project)) {
            str.append(project.toString());
        }
        return str.toString();
    }
}
