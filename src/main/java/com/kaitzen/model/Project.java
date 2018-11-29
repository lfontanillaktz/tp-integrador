package com.kaitzen.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROJECTO")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private long id;

    @Column(name = "NOMBRE",nullable = false)
    private String name;

    @Column(name = "FECHA_DE_INICIO")
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Client client;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project")
    @JsonIgnore private List<Employee> employees;

    public Project(){

    }

    public Project(String name, Date date){
        this.name = name;
        this.startDate = date;
        employees = new ArrayList<Employee>();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
