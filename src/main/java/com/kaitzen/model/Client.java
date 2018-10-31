package com.kaitzen.model;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE",nullable = false, length = 50)
    private String name;

    public Client() {
    }

    public Client(Long id){
        this.id = id;
    }

    public Client(String name){
        this.name = name;
    }

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
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
}