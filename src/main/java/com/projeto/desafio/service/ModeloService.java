package com.projeto.desafio.service;

import com.projeto.desafio.domain.Marca;
import com.projeto.desafio.domain.Modelo;
import com.projeto.desafio.repository.ModeloRepository;
import com.projeto.desafio.requests.ModeloPostRequestBody;
import com.projeto.desafio.requests.ModeloPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModeloService {
    private final ModeloRepository modeloRepository;
    private final MarcaService marcaService;

    public List<Modelo> listAll() {
        return modeloRepository.findAll();
    }

    public Modelo findById(long id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo não encontrado"));
    }

    public List<Modelo> findByName(String nome) {
        return modeloRepository.findByNome(nome);
    }

    public Modelo save(ModeloPostRequestBody modeloPostRequestBody) {
        Marca marcaAssociadaAoModelo = marcaAssociadaAoModelo(modeloPostRequestBody.getMarcaId());
        if (marcaAssociadaAoModelo.getId() != null) {
            return modeloRepository.save(Modelo.builder()
                    .nome(modeloPostRequestBody.getNome())
                    .ativo(modeloPostRequestBody.getAtivo())
                    .ano(modeloPostRequestBody.getAno())
                    .marca(marcaAssociadaAoModelo)
                    .build());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca associada ao modelo não encontrada");
        }
    }

    public void saveAll(List<ModeloPostRequestBody> modeloPostRequestBodyList) {
        modeloPostRequestBodyList
                .forEach(this::save);
    }

    public void replace(ModeloPutRequestBody modeloPutRequestBody) {
        Modelo modeloSalvo = findById(modeloPutRequestBody.getId());
        Marca marcaAssociadaAoModelo = marcaAssociadaAoModelo(modeloSalvo.getMarca().getId());

        if (modeloSalvo.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo não encontrado");
        }
        if (marcaAssociadaAoModelo.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca associada ao modelo não encontrada");
        }

        Modelo modelo = Modelo.builder()
                .id(modeloSalvo.getId())
                .nome(modeloPutRequestBody.getNome())
                .marca(marcaAssociadaAoModelo)
                .ano(modeloPutRequestBody.getAno())
                .ativo(modeloPutRequestBody.getAtivo())
                .build();

        modeloRepository.save(modelo);

    }


    public void delete(long id) {
        modeloRepository.delete(findById(id));
    }

    private Marca marcaAssociadaAoModelo(long id) {
        return marcaService.findById(id);
    }
}



