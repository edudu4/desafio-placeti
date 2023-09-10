package com.projeto.desafio.controller;

import com.projeto.desafio.domain.Modelo;
import com.projeto.desafio.requests.ModeloPostRequestBody;
import com.projeto.desafio.requests.ModeloPutRequestBody;
import com.projeto.desafio.service.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("modelos")
@RequiredArgsConstructor
public class ModeloController {
    private final ModeloService modeloService;

    @GetMapping
    public ResponseEntity<List<Modelo>> list() {
        return ResponseEntity.ok(modeloService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Modelo> findById(@PathVariable long id) {
        return ResponseEntity.ok(modeloService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Modelo> save(@RequestBody ModeloPostRequestBody modeloPostRequestBody) {
        return new ResponseEntity<>(modeloService.save(modeloPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ModeloPutRequestBody modeloPutRequestBody) {
        modeloService.replace(modeloPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        modeloService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
