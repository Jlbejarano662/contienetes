package com.alkemy.continentes.continentes.service.impl;

import com.alkemy.continentes.continentes.dto.ContinenteDTO;
import com.alkemy.continentes.continentes.entity.ContinenteEntity;
import com.alkemy.continentes.continentes.mapper.ContinenteMapper;
import com.alkemy.continentes.continentes.repository.ContinenteRepository;
import com.alkemy.continentes.continentes.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepository continenteRepository;

    public ContinenteDTO save(ContinenteDTO dto) {
        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
        ContinenteEntity entitySave = continenteRepository.save(entity);
        ContinenteDTO result = continenteMapper.ContinenteEntity2DTO(entitySave);
        System.out.println("GUARDAR CONTINENTE");
        return result;
    }

    public List<ContinenteDTO> getAllContinentes() {
        List<ContinenteEntity> entities = continenteRepository.findAll();
        List<ContinenteDTO> result = continenteMapper.ContinenteEntity2DTOList(entities);
        return result;
    }
}
