package com.alkemy.continentes.continentes.dto;

import com.alkemy.continentes.continentes.entity.ContinenteEntity;
import com.alkemy.continentes.continentes.entity.IconEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PaisDTO {

    private Long id;

    private  String imagen;

    private String denominacion;

    private Long cantidadHabitantes;

    private Long superficie;

    private Long continenteId;

    private List<IconDTO> icons;

}
