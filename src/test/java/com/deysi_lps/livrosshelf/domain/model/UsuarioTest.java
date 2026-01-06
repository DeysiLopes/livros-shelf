package com.deysi_lps.livrosshelf.domain.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a entidade de domínio Usuario.
 * Siga os TODOs para praticar TDD (Test-Driven Development).
 */
class UsuarioTest {

    @Test
    @Disabled("TODO: [TDD] Passo 1.4 - Implementar este teste")
    void deveCriarUsuarioComSucesso_quandoDadosSaoValidos() {
        // TODO: Implemente o teste para o "caminho feliz".
        // 1. Crie um usuário com nome e email válidos.
        // 2. Use assertNotNull para garantir que o ID do usuário não é nulo.
        // 3. Use assertEquals para garantir que o nome e o email foram atribuídos corretamente.

        String nomeValido = "joao das neves";
        String emailValido = " joaoNeves@email.com";
        
    }

    @Test
    @Disabled("TODO: [TDD] Passo 1.5 - Implementar este teste")
    void naoDeveCriarUsuario_quandoNomeEhNulo() {
        // TODO: Implemente o teste para validar a regra de negócio.
        // 1. Use assertThrows com IllegalArgumentException.class.
        // 2. Dentro do lambda, tente criar um novo usuário com um nome nulo.
        // 3. Verifique a mensagem da exceção para ter certeza que é a esperada.
    }

    @Test
    @Disabled("TODO: [TDD] Passo 1.6 - Implementar este teste")
    void naoDeveCriarUsuario_quandoNomeEhEmBranco() {
        // TODO: Implemente o teste para validar a regra de negócio.
        // 1. Use assertThrows com IllegalArgumentException.class.
        // 2. Tente criar um novo usuário com nome em branco ou apenas com espaços.
    }

    @Test
    @Disabled("TODO: [TDD] Passo 1.7 - Implementar este teste")
    void naoDeveCriarUsuario_quandoEmailEhInvalido() {
        // TODO: Implemente o teste para validar a regra de negócio.
        // 1. Use assertThrows com IllegalArgumentException.class.
        // 2. Tente criar um novo usuário com um email em formato inválido (ex: "email_invalido").
    }
}
