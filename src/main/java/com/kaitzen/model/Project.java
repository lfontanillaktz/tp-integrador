package com.kaitzen.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "PROYECTO")

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Long id;

    @Column(name = "NAME",nullable = false, length = 50)
    private String name;

    @Column(name = "FECHA_DE_INICIO")
    private Date startDate;

    @OneToOne   //Relaciona las tablas de uno a uno
    @JoinColumn(name="ID_CLIENTE")
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project") //Relaciona las tablas de uno a muchos
    //FetchType.Lazy le dice a proyecto que no levante la lista de empleados

    private List<Employee> employees;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Client getClient() {
        return client;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
