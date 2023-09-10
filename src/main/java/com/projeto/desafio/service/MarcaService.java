package com.projeto.desafio.service;

import com.projeto.desafio.domain.Marca;
import com.projeto.desafio.repository.MarcaRepository;
import com.projeto.desafio.requests.MarcaPostRequestBody;
import com.projeto.desafio.requests.MarcaPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public List<Marca> listAll() {
        return marcaRepository.findAll();
    }

    public Marca findById(long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca não encontrada"));
    }

    public Marca save(MarcaPostRequestBody marcaPostRequestBody) {
        return marcaRepository.save(Marca.builder()
                .nome(marcaPostRequestBody.getNome())
                .codigoDenatran(marcaPostRequestBody.getCodigoDenatran())
                .ativo(marcaPostRequestBody.getAtivo())
                .build());
    }

    public void replace(MarcaPutRequestBody marcaPutRequestBody) {
        Marca marcaSalva = findById(marcaPutRequestBody.getId());
        Marca marca = Marca.builder()
                .id(marcaSalva.getId())
                .codigoDenatran(marcaPutRequestBody.getCodigoDenatran())
                .nome(marcaPutRequestBody.getNome())
                .ativo(marcaPutRequestBody.getAtivo())
                .build();

        marcaRepository.save(marca);
    }

    public void delete(long id) {
        marcaRepository.delete(findById(id));
    }
}
