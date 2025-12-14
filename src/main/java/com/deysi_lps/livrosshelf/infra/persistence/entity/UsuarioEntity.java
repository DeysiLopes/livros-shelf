package com.deysi_lps.livrosshelf.infra.persistence.entity;

import com.deysi_lps.livrosshelf.domain.model.Usuario;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

/**
 * Representa a entidade Usuario como ela é salva no DynamoDB.
 * O uso de uma classe 'Entity' separada do modelo de domínio ('Usuario') é uma boa prática
 * para desacoplar a lógica de negócio das particularidades da tecnologia de persistência.
 */
@DynamoDbBean
public class UsuarioEntity {

    // TODO: [TDD] Passo 4.1 - Adicionar os atributos e anotações do DynamoDB.
    // Descomente as linhas abaixo.
    // private String id;
    // private String nome;
    // private String email;

    // TODO: [TDD] Passo 4.2 - Adicionar getters e setters.
    // O DynamoDB Enhanced Client precisa de getters e setters públicos para mapear os dados.

    @DynamoDbPartitionKey
    public String getId() {
        // TODO: Implementar getter
        return null;
    }

    // public void setId(String id) { ... }
    // public String getNome() { ... }
    // public void setNome(String nome) { ... }
    // public String getEmail() { ... }
    // public void setEmail(String email) { ... }


    /**
     * Converte um objeto de domínio 'Usuario' para uma 'UsuarioEntity' de persistência.
     * @param usuario O objeto de domínio.
     * @return A entidade de persistência.
     */
    public static UsuarioEntity fromDomain(Usuario usuario) {
        // TODO: [TDD] Passo 4.3 - Implementar a lógica de conversão.
        // Crie uma nova instância de UsuarioEntity e copie os dados do objeto de domínio.
        return new UsuarioEntity();
    }

    /**
     * Converte esta 'UsuarioEntity' de volta para um objeto de domínio 'Usuario'.
     * @return O objeto de domínio.
     */
    public Usuario toDomain() {
        // TODO: [TDD] Passo 4.4 - Implementar a lógica de conversão.
        // Crie uma nova instância de 'Usuario' usando os dados desta entidade.
        // Note que pode ser necessário um construtor privado ou um método fábrica em 'Usuario'
        // para recriar o objeto sem executar as validações novamente, se for o caso.
        return new Usuario(null, null);
    }
}
