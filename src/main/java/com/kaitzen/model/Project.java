package com.kaitzen.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROYECTO")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String name;

    @Column(name = "FECHAINICIO")
    private LocalDate startDate;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<Employee> employees;

    public Project() {

    }

    public Project(String name) {
        this.name = name;
        employees = new ArrayList<Employee>();
        startDate = LocalDate.now();
    }

    public Project(String name, LocalDate startDate) {
        this.name = name;
        employees = new ArrayList<Employee>();
        this.startDate = startDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", client=" + client +
                '}';
    }
}
