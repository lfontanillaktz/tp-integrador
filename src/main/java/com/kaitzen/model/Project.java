package com.kaitzen.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Projecto")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nombre", nullable = false,length = 50)
    private String name;

    @Column(name = "Fecha_Inicio")
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<Employee> employees;

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

    public Date getStartDtade() {
        return startDate;
    }

    public void setStartDtade(Date startDtade) {
        this.startDate = startDtade;
    }

    public Project(){}

    public Project(String name, Date startDate){
        this.name=name; this.startDate=startDate;
    }

}
