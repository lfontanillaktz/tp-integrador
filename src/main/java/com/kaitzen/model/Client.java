package com.kaitzen.model;


import javax.persistence.*;

@Entity
@Table(name = "CLIENT")


public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")

    private long Id;

    @Column(name = "NOMBRE", nullable = false , length = 50)
    private String name;

    public Client(){}

    public Client(String name){
        this.name = name;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
