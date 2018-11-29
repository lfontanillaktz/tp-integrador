package com.kaitzen.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kaitzen.model.Client;

import java.util.Date;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProjectDTO {

    private String name;
    private String starDate;
    private Long clientId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
