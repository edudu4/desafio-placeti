package com.projeto.desafio.repository;

import com.projeto.desafio.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    List<Marca> findByNome(String nome);
}
