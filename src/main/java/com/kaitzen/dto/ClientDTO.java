package com.kaitzen.dto;

import org.springframework.web.bind.annotation.PostMapping;

public class ClientDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
