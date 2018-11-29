package com.kaitzen.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "CLIENTE")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @NotBlank
    @Column(name = "NOMBRE", nullable = false , length = 50)
    private String name;

    public Client(){}

    public Client(String name){
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append("Id: ");
        str.append(id);
        str.append(" Nombre: ");
        str.append(name);
        return str.toString();
    }
}
