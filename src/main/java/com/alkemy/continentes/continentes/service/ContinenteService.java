package com.alkemy.continentes.continentes.service;

import com.alkemy.continentes.continentes.dto.ContinenteDTO;

import java.util.List;

public interface ContinenteService {

   ContinenteDTO save(ContinenteDTO dto);

    List<ContinenteDTO> getAllContinentes();
}
