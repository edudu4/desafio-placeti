package com.projeto.desafio.requests;

import lombok.Data;

@Data
public class ModeloPutRequestBody {
    long id;
    String nome;
    String ano;
    Boolean ativo;
    long marcaId;
}
