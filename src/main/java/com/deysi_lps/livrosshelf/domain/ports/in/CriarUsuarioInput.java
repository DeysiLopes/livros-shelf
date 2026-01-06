package com.deysi_lps.livrosshelf.domain.ports.in;

/**
 * Objeto de entrada para o caso de uso de criação de usuário.
 * Definido na camada de domínio para que a porta de entrada possa usá-lo
 * sem depender da camada de aplicação.
 */
public record CriarUsuarioInput(String nome, String email) {
}

