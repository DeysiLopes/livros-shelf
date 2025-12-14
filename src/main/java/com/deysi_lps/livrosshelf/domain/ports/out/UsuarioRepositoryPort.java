package com.deysi_lps.livrosshelf.domain.ports.out;

import com.deysi_lps.livrosshelf.domain.model.Usuario;

public interface UsuarioRepositoryPort {
    void salvar(Usuario usuario);
}
