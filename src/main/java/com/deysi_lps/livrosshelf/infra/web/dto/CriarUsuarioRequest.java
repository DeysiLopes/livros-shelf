package com.deysi_lps.livrosshelf.infra.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO (Data Transfer Object) para a requisição de criação de usuário.
 * Representa os dados que chegam pela API. O uso de 'record' simplifica a criação
 * de classes de dados imutáveis.
 * As anotações de validação garantem que os dados são verificados antes de chegar
 * ao controller.
 */
public record CriarUsuarioRequest(
    // TODO: [TDD] Passo 3.1 - Conhecer o DTO.
    // Nenhuma ação necessária aqui, apenas entenda que esta classe representa
    // o JSON que será enviado no corpo da requisição POST.
    // Ex: { "nome": "John Doe", "email": "john.doe@example.com" }

    @NotBlank(message = "O nome não pode estar em branco.")
    String nome,

    @NotBlank(message = "O email não pode estar em branco.")
    @Email(message = "O formato do email é inválido.")
    String email
) {
}
