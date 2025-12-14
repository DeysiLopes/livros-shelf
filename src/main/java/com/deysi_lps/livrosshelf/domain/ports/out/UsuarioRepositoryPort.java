package com.deysi_lps.livrosshelf.domain.ports.out;

import com.deysi_lps.livrosshelf.domain.model.Usuario;

public interface UsuarioRepositoryPort {
    void salvar(Usuario usuario);

    // TODO: Adicionar métodos para buscar usuários, se necessário para o lado de comando.
    // Para o lado de Query (CQRS), é provável que você tenha uma porta e adaptador separados.
}
