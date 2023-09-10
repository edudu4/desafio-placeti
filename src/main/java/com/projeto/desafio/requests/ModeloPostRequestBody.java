package com.projeto.desafio.requests;

import lombok.Data;

@Data
public class ModeloPostRequestBody {
    String nome;
    String ano;
    Boolean ativo;
    long marcaId;
}
