package com.alkemy.continentes.continentes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//TODO: FALTA IMPLEMENTAR ESTOS ATRIBUTOS
public class PaisFiltersDTO {

    private String name;
    private String continenteId;
    private String order;

    public PaisFiltersDTO(String name, String continenteId, String order) {
        this.name = name;
        this.continenteId = continenteId;
        this.order = order;
    }
    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }
    public boolean isDESC(){
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
