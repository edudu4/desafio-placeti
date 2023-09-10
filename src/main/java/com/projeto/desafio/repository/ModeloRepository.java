package com.projeto.desafio.repository;

import com.projeto.desafio.domain.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
