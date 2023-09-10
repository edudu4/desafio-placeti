package com.projeto.desafio.requests;

import lombok.Data;

@Data
public class MarcaPutRequestBody {
    Long id;
    String codigoDenatran;
    String nome;
    Boolean ativo;
}
