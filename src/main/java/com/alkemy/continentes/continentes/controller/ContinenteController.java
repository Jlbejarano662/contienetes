package com.alkemy.continentes.continentes.controller;

import com.alkemy.continentes.continentes.dto.ContinenteDTO;
import com.alkemy.continentes.continentes.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;

    @GetMapping
    public ResponseEntity<List<ContinenteDTO>> getAll() {
        List<ContinenteDTO> continentes = continenteService.getAllContinentes();
        return ResponseEntity.ok().body(continentes);
    }

    @PostMapping
    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
        ContinenteDTO continenteGuardado = continenteService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
    }

}
