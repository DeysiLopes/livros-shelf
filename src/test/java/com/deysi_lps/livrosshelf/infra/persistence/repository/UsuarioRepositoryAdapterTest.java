package com.deysi_lps.livrosshelf.infra.persistence.repository;

import com.deysi_lps.livrosshelf.domain.model.Usuario;
import com.deysi_lps.livrosshelf.infra.persistence.entity.UsuarioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Teste unitário para o UsuarioRepositoryAdapter.
 * O foco é verificar se o adaptador chama corretamente o cliente do DynamoDB.
 * NOTA: Este é um teste unitário. Em um projeto real, um teste de INTEGRAÇÃO
 * usando Testcontainers com uma instância local do DynamoDB seria mais valioso
 * para garantir a correta configuração das anotações da entidade e a comunicação
 * com o banco.
 */
@ExtendWith(MockitoExtension.class)
class UsuarioRepositoryAdapterTest {

    @Mock
    private DynamoDbEnhancedClient enhancedClient;

    @Mock
    private DynamoDbTable<UsuarioEntity> usuarioTable;

    private UsuarioRepositoryAdapter usuarioRepositoryAdapter;

    @BeforeEach
    void setUp() {
        // TODO: [TDD] Passo 4.6 - Configurar o ambiente de teste.
        // 1. "Ensine" ao mock do enhancedClient que, quando o método table() for chamado,
        //    ele deve retornar o nosso mock da tabela 'usuarioTable'.
        //    Use: when(enhancedClient.table(any(), any(TableSchema.class))).thenReturn(usuarioTable);
        // 2. Instancie o 'usuarioRepositoryAdapter' com o mock do 'enhancedClient'.
        //    usuarioRepositoryAdapter = new UsuarioRepositoryAdapter(enhancedClient);
    }

    @Test
    @Disabled("TODO: [TDD] Passo 4.8 - Implementar este teste")
    void deveChamarPutItemDoDynamoDb_quandoSalvar() {
        // TODO: Implemente o teste para o adaptador.
        // 1. Crie um objeto de domínio 'Usuario' para ser o "input" do método.
        // 2. Chame o método 'salvar' do 'usuarioRepositoryAdapter'.
        // 3. Capture o 'UsuarioEntity' que foi passado para o método 'putItem' da tabela mockada.
        //    Use 'ArgumentCaptor.forClass(UsuarioEntity.class)'.
        // 4. Verifique (com 'verify') se o método 'putItem' da 'usuarioTable' foi chamado.
        // 5. Use o captor para verificar se os dados na entidade capturada correspondem aos
        //    do objeto de domínio original.
    }
}
