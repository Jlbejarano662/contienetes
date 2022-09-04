package com.alkemy.continentes.continentes.service.impl;

import com.alkemy.continentes.continentes.dto.IconBasicDTO;
import com.alkemy.continentes.continentes.dto.IconDTO;
import com.alkemy.continentes.continentes.dto.IconFiltersDTO;
import com.alkemy.continentes.continentes.entity.IconEntity;
import com.alkemy.continentes.continentes.entity.PaisEntity;
import com.alkemy.continentes.continentes.exception.ParamNotFound;
import com.alkemy.continentes.continentes.mapper.IconMapper;
import com.alkemy.continentes.continentes.repository.IconRepository;
import com.alkemy.continentes.continentes.repository.specifications.IconSpecification;
import com.alkemy.continentes.continentes.service.IconService;
import com.alkemy.continentes.continentes.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IconServiceImpl implements IconService {

    private IconRepository iconRepository;

    private IconSpecification iconSpecification;

    private IconMapper iconMapper;

    private PaisService paisService;

    @Autowired
    public IconServiceImpl (
            IconRepository iconRepository,
            IconSpecification iconSpecification,
            IconMapper iconMapper,
            PaisService paisService
    ) {
       this.iconRepository = iconRepository;
       this.iconSpecification = iconSpecification;
       this.iconMapper = iconMapper;
       this.paisService = paisService;
    }

    public List<IconBasicDTO> getAll() {
        List<IconEntity> entities = this.iconRepository.findAll();
        List<IconBasicDTO> iconBasicDTOS = this.iconMapper.iconEntitySet2BasicDTOList(entities);
        return iconBasicDTOS;
    }

    public IconDTO getDetailsById(Long id) {
        Optional<IconEntity> entity = this.iconRepository.findById(id);
        if(!entity.isPresent()) {
            throw new ParamNotFound("Id icono no valido");
        }
        IconDTO iconDTO = this.iconMapper.iconEntity2DTO(entity.get(), true);
        return  iconDTO;
    }

    public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        IconFiltersDTO filtersDTO = new IconFiltersDTO(name, date, cities, order);
        List<IconEntity> entities = this.iconRepository.findAll(this.iconSpecification.getByFilters(filtersDTO));
        List<IconDTO> dtos = this.iconMapper.iconEntitySet2DTOList(entities, true);
        return dtos;
    }

    public IconDTO save(IconDTO iconDTO) {
        IconEntity entity = this.iconMapper.iconDTO2Entity(iconDTO);
        IconEntity entitySave = this.iconRepository.save(entity);
        IconDTO result = this.iconMapper.iconEntity2DTO(entitySave, false);
        return result;
    }

    public IconDTO update(Long id, IconDTO iconDTO) {
        Optional<IconEntity> entity = this.iconRepository.findById(id);
        if(!entity.isPresent()) {
            throw new ParamNotFound("Id icono no valido");
        }
        this.iconMapper.iconEntityRefreshValues(entity.get(), iconDTO);
        IconEntity entitySaved = this.iconRepository.save(entity.get());
        IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved, false);
        return result;
    }

    public void removePais(Long id, Long idPais) {
        IconEntity entity = this.iconRepository.getById(idPais);
        entity.getPaises().size();
        PaisEntity paisEntity = this.paisService.getEntityById(idPais);
        entity.removePais(paisEntity);
        this.iconRepository.save(entity);
    }

    public void addPais(Long id, Long idPais) {
        IconEntity entity = this.iconRepository.getById(id);
        PaisEntity paisEntity = this.paisService.getEntityById(idPais);
        //System.out.println(paisEntity);
        entity.addPais(paisEntity);
        System.out.println(entity.getPaises());
        this.iconRepository.save(entity);
    }

    public void delete(Long id) {
        this.iconRepository.deleteById(id);
    }

}
