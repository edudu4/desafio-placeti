package com.projeto.desafio.controller;

import com.projeto.desafio.domain.Modelo;
import com.projeto.desafio.service.MarcaModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("marcasmodelos")
@RequiredArgsConstructor
public class MarcaModeloController {
    private final MarcaModeloService marcaModeloService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Modelo>> listarModelosPorMarca(@PathVariable long id) {
        return ResponseEntity.ok(marcaModeloService.listarModelosPorMarca(id));
    }
}
