package com.projeto.desafio.requests;

import com.projeto.desafio.domain.Modelo;
import lombok.Data;

import java.util.List;

@Data
public class MarcaPostRequestBody {
    private String nome;
    private String codigoDenatran;
    private Boolean ativo;
}
