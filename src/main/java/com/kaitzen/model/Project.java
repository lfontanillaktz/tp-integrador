package com.kaitzen.model;

import javax.persistence.*;
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
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<Employee> employees;

    public Project() {

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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", client=" + client +
                ", employees=" + employees +
                '}';
    }
}
