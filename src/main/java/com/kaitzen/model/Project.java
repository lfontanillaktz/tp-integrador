package com.kaitzen.model;

import com.kaitzen.utils.Seniority;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PROYECTO")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NOMBRE",nullable = false,length = 50)
    private String name;

    @Column(name="FECHA_DE_INICIO")
    private Date startDate;

    @OneToOne
    @JoinColumn(name="ID_CLIENTE")
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<Employee> employees;

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

    public Project(){}

    public Project(String name, Date startDate, Client client, List<Employee> employees) {
        this.name = name;
        this.startDate = startDate;
        this.client = client;
        this.employees = employees;
    }
}
