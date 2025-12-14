package com.deysi_lps.livrosshelf.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

/**
 * Classe de configuração do Spring para criar os Beans relacionados ao AWS DynamoDB.
 * Separar a configuração da infraestrutura em classes dedicadas mantém o código
 * organizado e facilita a manutenção.
 */
@Configuration
public class DynamoDbConfig {

    // TODO: [TDD] Passo 5.1 - Entender a configuração de Beans.
    // Esta classe instrui o Spring a criar e gerenciar os clientes do DynamoDB.
    // O Spring irá injetar esses beans automaticamente onde forem necessários
    // (como no construtor do UsuarioRepositoryAdapter).
    // Nenhuma ação é necessária aqui, mas é crucial entender este conceito.

    /**
     * Cria o cliente de baixo nível do DynamoDB.
     * @return Uma instância do DynamoDbClient.
     */
    @Bean
    public DynamoDbClient dynamoDbClient() {
        // Este cliente será configurado automaticamente pelo Spring Boot
        // com as credenciais e região padrão da AWS no ambiente.
        return DynamoDbClient.builder().build();
    }

    /**
     * Cria o cliente avançado (Enhanced Client) que será usado nos repositórios.
     * @param dynamoDbClient O cliente de baixo nível criado pelo Spring.
     * @return Uma instância do DynamoDbEnhancedClient.
     */
    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }
}
