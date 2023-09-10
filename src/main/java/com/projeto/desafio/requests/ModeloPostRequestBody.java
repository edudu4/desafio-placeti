package com.projeto.desafio.requests;

import com.projeto.desafio.domain.Marca;
import com.projeto.desafio.service.MarcaService;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Data
@RequiredArgsConstructor
public class ModeloPostRequestBody {
    private String nome;
    private String ano;
    private Boolean ativo;
    private long marcaId;

    private final MarcaService marcaService;

    @PostConstruct
    public void validaMarca() {
        if (getMarca().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca associada ao modelo não encontrada");
        }
    }

    public Marca getMarca() {
        return marcaService.findById(marcaId);
    }
}
