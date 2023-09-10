package com.projeto.desafio.repository;

import com.projeto.desafio.domain.Marca;
import com.projeto.desafio.domain.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarcaModeloRepository extends JpaRepository<Modelo,Long> {
    List<Modelo> findByMarca(Marca marca);
}
