package com.alkemy.continentes.continentes.service;

import com.alkemy.continentes.continentes.dto.IconBasicDTO;
import com.alkemy.continentes.continentes.dto.IconDTO;

import java.util.List;
import java.util.Set;

public interface IconService {

    List<IconBasicDTO> getAll();

    IconDTO getDetailsById(Long id);

    List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order);

    IconDTO save(IconDTO icon);

    IconDTO update(Long id, IconDTO icon);

    void removePais(Long id, Long idPais);

    void addPais(Long id, Long idPais);

    void delete(Long id);

}
