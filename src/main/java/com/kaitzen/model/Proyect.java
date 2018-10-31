package com.kaitzen.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Proyecto")

public class Proyect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "ID")
    private Long id;

    @Column(name = "NOMBRE",nullable = false, length = 50)
    private String name;

    @Column(name = "FECHA_INICIO")
    private Date startDate;

    public Proyect() {
    }

}
