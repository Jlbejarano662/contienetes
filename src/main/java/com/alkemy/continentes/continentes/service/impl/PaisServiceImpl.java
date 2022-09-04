package com.alkemy.continentes.continentes.service.impl;

import com.alkemy.continentes.continentes.dto.PaisDTO;
import com.alkemy.continentes.continentes.dto.PaisDTO2;
import com.alkemy.continentes.continentes.entity.PaisEntity;
import com.alkemy.continentes.continentes.exception.ParamNotFound;
import com.alkemy.continentes.continentes.mapper.PaisMapper;
import com.alkemy.continentes.continentes.repository.PaisRepository;
import com.alkemy.continentes.continentes.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisMapper paisMapper;

    @Autowired
    private PaisRepository paisRepository;

    public PaisEntity getEntityById(Long id) {
        Optional<PaisEntity> entity = this.paisRepository.findById(id);
        if(!entity.isPresent()) {
            throw new ParamNotFound("Id pais no valido");
        }
        //PaisDTO paisDTO = this.paisMapper.paisEntity2DTO(entity.get(), true);
        return  entity.get();
    }

    public List<PaisDTO> getAllPaises() {
        List<PaisEntity> entities = paisRepository.findAll();
        List<PaisDTO> result = paisMapper.paisEntityList2DTOList(entities,false);
        return result;
    }

    public PaisDTO save(PaisDTO2 dto) {
        System.out.println(dto.getIcons());
        PaisEntity entity = paisMapper.paisDTO2Entity2(dto);
        System.out.println(entity);
        PaisEntity entitySave = paisRepository.save(entity);
        PaisDTO result = paisMapper.paisEntity2DTO(entitySave, false);
        return result;
    }

}
