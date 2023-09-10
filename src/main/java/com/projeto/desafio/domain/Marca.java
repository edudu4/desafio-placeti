package com.projeto.desafio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marca_id")
    Long id;
    String codigoDenatran;
    String nome;
    Boolean ativo;
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    List<Modelo> modelos;
}
