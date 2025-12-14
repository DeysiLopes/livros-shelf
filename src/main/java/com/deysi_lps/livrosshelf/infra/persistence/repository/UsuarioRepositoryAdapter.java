package com.deysi_lps.livrosshelf.infra.persistence.repository;

import com.deysi_lps.livrosshelf.domain.model.Usuario;
import com.deysi_lps.livrosshelf.domain.ports.out.UsuarioRepositoryPort;
import com.deysi_lps.livrosshelf.infra.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

/**
 * Adaptador de Saída (Secondary Adapter) para persistência no DynamoDB.
 * Implementa a porta de saída definida no domínio, traduzindo as chamadas
 * para a tecnologia específica do DynamoDB.
 */
@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final DynamoDbTable<UsuarioEntity> usuarioTable;

    public UsuarioRepositoryAdapter(DynamoDbEnhancedClient enhancedClient) {
        // TODO: [TDD] Passo 4.5 - Injetar o client do DynamoDB e obter a tabela.
        // Descomente a linha abaixo.
        // this.usuarioTable = enhancedClient.table("Usuario", TableSchema.fromBean(UsuarioEntity.class));
    }

    @Override
    public void salvar(Usuario usuario) {
        // TODO: [TDD] Passo 4.7 - Implementar o método de persistência.
        // 1. Converta o objeto de domínio 'Usuario' para uma 'UsuarioEntity'.
        //    (UsuarioEntity.fromDomain(usuario))
        // 2. Use o método 'putItem' da 'usuarioTable' para salvar a entidade no DynamoDB.
    }
}
