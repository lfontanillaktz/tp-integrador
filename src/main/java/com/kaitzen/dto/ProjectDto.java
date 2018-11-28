package com.kaitzen.dto;

import com.kaitzen.model.Client;
import com.kaitzen.model.Employee;

import java.util.Date;
import java.util.List;

public class ProjectDto {
    private long id;
    private String name;
    private Date startDate;
    private Client client;

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
}
