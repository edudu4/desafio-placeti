package com.projeto.desafio.requests;

import com.projeto.desafio.domain.Marca;
import com.projeto.desafio.domain.Modelo;
import com.projeto.desafio.service.MarcaService;
import com.projeto.desafio.service.ModeloService;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Data
@RequiredArgsConstructor
public class ModeloPutRequestBody {
    private long id;
    private String nome;
    private String ano;
    private Boolean ativo;
    private long marcaId;

    private final MarcaService marcaService;
    private final ModeloService modeloService;

    @PostConstruct
    public void validaMarca() {
        if (getMarca().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca associada ao modelo não encontrada");
        }
    }

    public Modelo getModeloExistente() {
        Modelo modelo = modeloService.findById(id);

        if (modelo.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo não encontrado");
        }

        return modelo;
    }

    public Marca getMarca() {
        return marcaService.findById(marcaId);
    }

}
