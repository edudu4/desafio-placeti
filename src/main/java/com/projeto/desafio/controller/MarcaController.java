package com.projeto.desafio.controller;

import com.projeto.desafio.domain.Marca;
import com.projeto.desafio.requests.MarcaPostRequestBody;
import com.projeto.desafio.requests.MarcaPutRequestBody;
import com.projeto.desafio.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("marcas")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> list() {
        return ResponseEntity.ok(marcaService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Marca> findById(@PathVariable long id) {
        return ResponseEntity.ok(marcaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Marca> save(@RequestBody MarcaPostRequestBody marcaPostRequestBody) {
        return new ResponseEntity<>(marcaService.save(marcaPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody MarcaPutRequestBody marcaPutRequestBody) {
        marcaService.replace(marcaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        marcaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
