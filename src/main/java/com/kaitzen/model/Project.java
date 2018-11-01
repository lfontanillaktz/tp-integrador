package com.kaitzen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PROYECTO")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "FECHA_DE_INICIO")
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<Employee> employees;

    public Project() {}

    public Project(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
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

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Id: ");
        str.append(id);
        str.append(" Nombre: ");
        str.append(name);
        str.append(" Fecha de Inicio: ");
        str.append(startDate.toString());
        if (Objects.nonNull(client)) {
            str.append(" Cliente: ");
            str.append(client.toString());
        }
        return str.toString();
    }
}
