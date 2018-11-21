package com.kaitzen.dto;

import com.kaitzen.Modelos.Client;

import java.util.Date;

public class ProjectDTO {

    private String name;
    private Date startDate;
    private Client client;

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Client getClient() {
        return client;
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
}
