package com.kaitzen.model;

import com.kaitzen.utils.Seniority;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLEADO")
public class Employee {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column (name = "Id")
    private long id;


    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String name;

    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ANTIGUEDAD",nullable = false, length = 50)
    private Seniority seniority;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO")
    private Project project;


    public Employee() {}

    public Employee(String name, String lastName, Seniority seniority){
        this.name = name;
        this.lastName = lastName;
        this.seniority = seniority;
    }

    public Employee(String name, String lastName, Seniority seniority, Project project){
        this.name = name;
        this.lastName = lastName;
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
    public  String toString(){
        StringBuffer str = new StringBuffer();
        str.append("Id: ");
        str.append(id);
        str.append(" Nombre: ");
        str.append(name);
        str.append(" Apellido: ");
        str.append(lastName);
        str.append(" Antiguedad: ");
        str.append(seniority);
        str.append(" Proyecto: ");
        if (Objects.nonNull(project)){
            str.append(project.toString());
        }
        return str.toString();
    }
}
