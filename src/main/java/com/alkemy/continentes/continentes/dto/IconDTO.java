package com.alkemy.continentes.continentes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class IconDTO {

    private Long id;

    private String imagen;

    private String denominacion;

    private String fechaCreacion;

    private Long altura;

    private String historia;

    private List<PaisDTO>  paises;

}
