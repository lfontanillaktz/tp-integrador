package com.kaitzen.utils;

public enum Seniority {

    JUNIOR ("Junior"),
    SEMI_SENIOR ("Semi Senior"),
    SENIOR ("Senior"),
    SOFTWARE_DESIGNER ("Software Designer"),
    ARCHITECT ("Architect");

    private String description;

    private Seniority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
