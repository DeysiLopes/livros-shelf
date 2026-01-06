package com.deysi_lps.livrosshelf.domain.model;

import lombok.Data;

import java.util.UUID;

/**
 * Representa a entidade de domínio Usuario.
 * Esta é a classe central para o negócio, contendo os dados e as regras de negócio
 * que não dependem de nenhuma tecnologia externa (frameworks, bancos de dados, etc.).
 */
@Data
public class Usuario {

     private final UUID id;
     private final String nome;
     private final String email;

    /**
     * Construtor para criar um novo usuário.
     * É aqui que as regras de negócio para a criação de um usuário devem ser aplicadas.
     *
     * @param nome O nome do usuário.
     */
    public Usuario(UUID id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

}
