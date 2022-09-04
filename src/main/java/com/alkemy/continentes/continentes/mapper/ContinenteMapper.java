package com.alkemy.continentes.continentes.mapper;

import com.alkemy.continentes.continentes.dto.ContinenteDTO;
import com.alkemy.continentes.continentes.entity.ContinenteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {

    public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto) {
        ContinenteEntity continenteEntity = new ContinenteEntity();
        continenteEntity.setImagen(dto.getImagen());
        continenteEntity.setDenominacion(dto.getDenominacion());
        return continenteEntity;
    }

    public ContinenteDTO ContinenteEntity2DTO(ContinenteEntity entity) {
        ContinenteDTO dto = new ContinenteDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;
    }

    public List<ContinenteDTO> ContinenteEntity2DTOList(List<ContinenteEntity> entities) {
        List<ContinenteDTO> dtos = new ArrayList<>();
        for (ContinenteEntity entity: entities) {
            dtos.add(ContinenteEntity2DTO(entity));
        }
        return dtos;
    }
}
