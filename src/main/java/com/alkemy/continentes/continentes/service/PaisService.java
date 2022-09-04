package com.alkemy.continentes.continentes.service;

import com.alkemy.continentes.continentes.dto.PaisDTO;
import com.alkemy.continentes.continentes.dto.PaisDTO2;
import com.alkemy.continentes.continentes.entity.PaisEntity;

import java.util.List;

public interface PaisService {
    PaisEntity getEntityById(Long idPais);

    List<PaisDTO> getAllPaises();

    PaisDTO save(PaisDTO2 pais);

}
