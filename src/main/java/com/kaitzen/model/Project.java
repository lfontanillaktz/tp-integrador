package com.kaitzen.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "PROYECTO")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="nombre",nullable = false, length = 50)
    private String name;

    @Column(name="FECHA_INICIO")
    private Date startDate;

    @OneToOne
    @JoinColumn(name="ID_CLIENTE")
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<Employee> employees;

    public Project(){}

    public Project(String name, Date startDate, Client client, List<Employee> employees) {
        this.name = name;
        this.startDate = startDate;
        this.client = client;
        this.employees = employees;
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
    public void setClient(Client client){
        this.client=client;
    }
    public Client getClient(){
        return this.client;
    }
}
