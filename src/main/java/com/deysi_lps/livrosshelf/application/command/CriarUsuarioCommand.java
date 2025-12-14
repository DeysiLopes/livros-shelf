package com.deysi_lps.livrosshelf.application.command;

import com.deysi_lps.livrosshelf.domain.model.Usuario;

public class CriarUsuarioCommand {
    private final String nome;
    private final String email;

    public CriarUsuarioCommand(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
