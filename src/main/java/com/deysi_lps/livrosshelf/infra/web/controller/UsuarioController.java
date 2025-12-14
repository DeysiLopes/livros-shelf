package com.deysi_lps.livrosshelf.infra.web.controller;

import com.deysi_lps.livrosshelf.application.command.CriarUsuarioCommand;
import com.deysi_lps.livrosshelf.domain.ports.in.UsuarioServicePort;
import com.deysi_lps.livrosshelf.infra.web.dto.CriarUsuarioRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Adaptador de Entrada (Primary Adapter) do tipo Web/HTTP.
 * Expõe as funcionalidades da aplicação como endpoints REST.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServicePort usuarioServicePort;

    public UsuarioController(UsuarioServicePort usuarioServicePort) {
        // TODO: [TDD] Passo 3.2 - Injeção de Dependência
        // Descomente a linha abaixo.
        // this.usuarioServicePort = usuarioServicePort;
    }

    @PostMapping
    public ResponseEntity<Void> criarUsuario(@Valid @RequestBody CriarUsuarioRequest request) {
        // TODO: [TDD] Passo 3.4 - Implementar o método do controller.
        // 1. Crie um 'CriarUsuarioCommand' a partir do 'request' recebido.
        // 2. Chame o método 'criarUsuario' da porta do serviço ('usuarioServicePort').
        // 3. Retorne uma resposta HTTP 201 Created. O ideal é que o 'criarUsuario'
        //    retorne o ID do novo usuário para que ele possa ser incluído no header 'Location'.
        //    Por enquanto, vamos retornar uma URI vazia.
        return ResponseEntity.created(URI.create("")).build();
    }
}
