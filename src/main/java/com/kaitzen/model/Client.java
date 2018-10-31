package com.kaitzen.model;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Nombre", nullable = false,length = 50)
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Client(){}

    public Client(String name){
        this.name = name;
    }

}
