package com.deysi_lps.livrosshelf.application.service;

import com.deysi_lps.livrosshelf.domain.model.Usuario;
import com.deysi_lps.livrosshelf.domain.ports.in.CriarUsuarioInput;
import com.deysi_lps.livrosshelf.domain.ports.in.UsuarioServicePort;
import com.deysi_lps.livrosshelf.domain.ports.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Camada de Serviço da Aplicação.
 * Orquestra o fluxo do caso de uso "Criar Usuário":
 * 1. Recebe um Comando.
 * 2. Usa o modelo de domínio para executar a lógica.
 * 3. Usa a porta de saída para persistir o resultado.
 */
@Service
public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    /**
     * Construtor que recebe as dependências (portas de saída) necessárias.
     * A injeção de dependência é feita aqui, garantindo que o serviço não conhece
     * a implementação concreta do repositório.
     *
     * @param usuarioRepositoryPort A implementação da porta de repositório.
     */
    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public void criarUsuario(CriarUsuarioInput input) {
        // TODO: [TDD] Passo 2.3 - Implementar a lógica de orquestração.
        // 1. Crie uma instância do objeto de domínio 'Usuario' a partir dos dados do 'input'.
        //    (new Usuario(input.nome(), input.email()))
        // 2. Chame o método 'salvar' da porta do repositório para persistir o novo usuário.
    }
}
