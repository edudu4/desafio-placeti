package com.projeto.desafio.service;

import com.projeto.desafio.domain.Marca;
import com.projeto.desafio.domain.Modelo;
import com.projeto.desafio.repository.MarcaModeloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaModeloService {

    private final MarcaModeloRepository marcaModeloRepository;
    private final MarcaService marcaService;

    public List<Modelo> listarModelosPorMarca(long id) {
        Marca marca = marcaService.findById(id);
        if (marca.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return marcaModeloRepository.findByMarca(marca);
    }
}
