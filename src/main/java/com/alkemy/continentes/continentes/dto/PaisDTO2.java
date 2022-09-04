package com.alkemy.continentes.continentes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaisDTO2 {

    private Long id;

    private  String imagen;

    private String denominacion;

    private Long cantidadHabitantes;

    private Long superficie;

    private Long continenteId;

}
