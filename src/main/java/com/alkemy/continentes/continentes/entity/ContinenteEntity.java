package com.alkemy.continentes.continentes.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "continente")
@Getter
@Setter
public class ContinenteEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    private String denominacion;

}
