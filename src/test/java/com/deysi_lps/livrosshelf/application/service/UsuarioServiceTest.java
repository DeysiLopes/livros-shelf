package com.deysi_lps.livrosshelf.application.service;

import com.deysi_lps.livrosshelf.application.command.CriarUsuarioCommand;
import com.deysi_lps.livrosshelf.domain.model.Usuario;
import com.deysi_lps.livrosshelf.domain.ports.out.UsuarioRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Testes para o serviço de aplicação UsuarioService.
 * O objetivo é testar a lógica de orquestração, não a lógica de negócio do domínio
 * nem a implementação da persistência. Para isso, usamos Mocks.
 */
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepositoryPort usuarioRepositoryPort;

    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        // TODO: [TDD] Passo 2.2 - Configurar o ambiente de teste.
        // Descomente a linha abaixo para instanciar o serviço com o repositório mockado.
        // usuarioService = new UsuarioService(usuarioRepositoryPort);
    }

    @Test
    @Disabled("TODO: [TDD] Passo 2.4 - Implementar este teste")
    void deveCriarUsuarioEChamarRepositorio() {
        // TODO: Implemente o teste para o serviço.
        // 1. Crie um 'CriarUsuarioCommand' com dados de teste.
        //    (new CriarUsuarioCommand("Nome Teste", "email@teste.com"))
        // 2. Chame o método 'criarUsuario' do 'usuarioService'.
        // 3. Capture o argumento que foi passado para o método 'salvar' do repositório mockado.
        //    Use o 'ArgumentCaptor.forClass(Usuario.class)'.
        // 4. Verifique (com 'verify') se o método 'salvar' do repositório foi chamado exatamente 1 vez.
        // 5. Use o captor para pegar o objeto 'Usuario' que foi salvo.
        // 6. Verifique se os dados do usuário salvo (nome, email) correspondem aos dados do comando.
    }
}
