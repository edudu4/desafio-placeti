package com.projeto.desafio.requests;

import com.projeto.desafio.domain.Modelo;
import lombok.Data;

import java.util.List;

@Data
public class MarcaPostRequestBody {
    String nome;
    String codigoDenatran;
    Boolean ativo;
}
