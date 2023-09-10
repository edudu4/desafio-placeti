package com.projeto.desafio.requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
public class ModeloPutRequestBody {
    private long id;
    private String nome;
    private String ano;
    private Boolean ativo;
    private long marcaId;

}
