package com.projeto.desafio.requests;

import com.projeto.desafio.domain.Marca;
import com.projeto.desafio.service.MarcaService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Data
public class MarcaPutRequestBody {
    private Long id;
    private String codigoDenatran;
    private String nome;
    private Boolean ativo;

    private final MarcaService marcaService;

    public Marca getMarcaExistente() {
        Marca marca = marcaService.findById(id);

        if (marca.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca não encontrada");
        }

        return marca;
    }
}
