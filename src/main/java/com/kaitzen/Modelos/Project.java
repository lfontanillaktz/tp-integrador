package com.kaitzen.Modelos;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROYECTO")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NOMBRE",nullable = false, length = 50)
    private String name;

    @Column(name = "FECHA_DE_INICIO")
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = true) //JoinColumn dice que es Foreign key
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project") //lazy no levanta los empleados asociados, eager si levanta todos los empleados asociados al proyecto
    private List<Employee> employees;                           //"project" hace relacion a la variable project de la clase Employee



    public Project() {
    }

    public Project(String name, Date startDate, Client client) {
        this.name = name;
        this.startDate = startDate;
        this.client = client;
    }

    public Project(String name, Date startDate, Client client, List<Employee> employees) {
        this.name = name;
        this.startDate = startDate;
        this.client = client;
        this.employees = employees;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Client getClient() {
        return client;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
