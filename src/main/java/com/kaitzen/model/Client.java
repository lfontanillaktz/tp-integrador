package com.kaitzen.model;


import javax.persistence.*;

@Entity
@Table (name = "CLIENTE")
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_CLIENTE")
    private long id;
    @Column (name = "NOMBRE", nullable = false, length = 50)
    private String name;
    public Client () {}
    public Client (String name){
        this.name=name;
    }

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
}