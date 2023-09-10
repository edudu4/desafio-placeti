package com.projeto.desafio.requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
public class ModeloPostRequestBody {
    private String nome;
    private String ano;
    private Boolean ativo;
    private long marcaId;

}
