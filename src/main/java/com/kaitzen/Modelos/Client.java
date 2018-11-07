package com.kaitzen.Modelos;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE") //nombre de la tabla
public class Client {
    @Id //define el Primtary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //crea id secuenciales automaticamente
    @Column(name = "ID")
    private long id;

    @Column(name = "NOMBRE",nullable = false,length = 50) //no null, solo 50 caracteres
    private String name;


    public Client (){

    }

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

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

}
