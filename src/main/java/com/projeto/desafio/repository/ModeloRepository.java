package com.projeto.desafio.repository;

import com.projeto.desafio.domain.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findByNome(String nome);
}
