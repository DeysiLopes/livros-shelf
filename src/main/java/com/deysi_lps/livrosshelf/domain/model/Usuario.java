package com.deysi_lps.livrosshelf.domain.model;

import java.util.UUID;

/**
 * Representa a entidade de domínio Usuario.
 * Esta é a classe central para o negócio, contendo os dados e as regras de negócio
 * que não dependem de nenhuma tecnologia externa (frameworks, bancos de dados, etc.).
 */
public class Usuario {

    // TODO: [TDD] Passo 1.1 - Adicionar os atributos da classe.
    // Descomente as linhas abaixo.
    // private final String id;
    // private final String nome;
    // private final String email;

    /**
     * Construtor para criar um novo usuário.
     * É aqui que as regras de negócio para a criação de um usuário devem ser aplicadas.
     *
     * @param nome  O nome do usuário.
     * @param email O email do usuário.
     */
    public Usuario(String nome, String email) {
        // TODO: [TDD] Passo 1.3 - Implementar a lógica do construtor.
        // 1. Gere um ID único para o novo usuário (ex: UUID.randomUUID().toString()).
        // 2. Valide as entradas (nome e email). Se forem inválidas, lance uma exceção (ex: IllegalArgumentException).
        //    - O nome não pode ser nulo ou em branco.
        //    - O email não pode ser nulo e deve ter um formato válido.
        // 3. Atribua os valores validados aos atributos da classe.
        
        // this.id = UUID.randomUUID().toString(); // Exemplo
        // this.nome = nome;
        // this.email = email;
    }

    // TODO: [TDD] Passo 1.2 - Adicionar os getters para os atributos.
    // Crie os métodos get() para id, nome e email.
}
