package com.projeto.desafio.requests;

import lombok.Data;



@Data
public class MarcaPutRequestBody {
    private Long id;
    private String codigoDenatran;
    private String nome;
    private Boolean ativo;

}
