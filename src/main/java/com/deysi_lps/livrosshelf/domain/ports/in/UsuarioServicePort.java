package com.deysi_lps.livrosshelf.domain.ports.in;

import com.deysi_lps.livrosshelf.application.command.CriarUsuarioCommand;

public interface UsuarioServicePort {
    void criarUsuario(CriarUsuarioCommand criarUsuarioCommand);
}
