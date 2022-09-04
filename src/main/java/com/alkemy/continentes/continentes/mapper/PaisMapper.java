package com.alkemy.continentes.continentes.mapper;

import com.alkemy.continentes.continentes.dto.IconDTO;
import com.alkemy.continentes.continentes.dto.PaisDTO;
import com.alkemy.continentes.continentes.dto.PaisDTO2;
import com.alkemy.continentes.continentes.entity.IconEntity;
import com.alkemy.continentes.continentes.entity.PaisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class PaisMapper   {

    @Autowired()
    private IconMapper iconMapper;

    public PaisEntity paisDTO2Entity(PaisDTO dto) {
        PaisEntity entity = new PaisEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setCantidadHabitantes(dto.getCantidadHabitantes());
        entity.setSuperficie(dto.getSuperficie());
        entity.setContinenteId(dto.getContinenteId());
        //icons
        Set<IconEntity> icons = this.iconMapper.iconDTOList2Entity(dto.getIcons());
        entity.setIcons(icons);
        return entity;
    }
    public PaisEntity paisDTO2Entity2(PaisDTO2 dto) {
        PaisEntity entity = new PaisEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setCantidadHabitantes(dto.getCantidadHabitantes());
        entity.setSuperficie(dto.getSuperficie());
        entity.setContinenteId(dto.getContinenteId());
        //System.out.println(dto.getIcons());
        return entity;
    }
    public PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadIcons) {
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setSuperficie(entity.getSuperficie());
        if(loadIcons) {
            List<IconDTO> iconDTOS = this.iconMapper.iconEntitySet2DTOList(entity.getIcons(), false);
            dto.setIcons(iconDTOS);
        }
        return dto;
    }

    public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities, boolean loadIcons) {
        List<PaisDTO> dtos = new ArrayList<>();
        for(PaisEntity entity : entities) {
            dtos.add(this.paisEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }

    public List<PaisEntity> paisDTOList2Entity(List<PaisDTO> dtos) {
        List<PaisEntity> entities = new ArrayList<>();
        for (PaisDTO dto: dtos) {
            entities.add(this.paisDTO2Entity(dto));
        }
        return entities;
    }
    public void paisEntityRefreshValues(PaisEntity entity, PaisDTO paisDTO){
        entity.setCantidadHabitantes(paisDTO.getCantidadHabitantes());
        entity.setContinenteId(paisDTO.getContinenteId());
        entity.setSuperficie(paisDTO.getSuperficie());
        entity.setDenominacion(paisDTO.getDenominacion());
    }
}
