package com.deysi_lps.livrosshelf.infra.web.controller;

import com.deysi_lps.livrosshelf.domain.ports.in.CriarUsuarioInput;
import com.deysi_lps.livrosshelf.domain.ports.in.UsuarioServicePort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testes de camada web para o UsuarioController.
 * O @WebMvcTest sobe apenas o contexto web do Spring, não a aplicação inteira.
 * É mais rápido e focado que um teste de integração completo.
 */
@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioServicePort usuarioServicePort;

    @Test
    @Disabled("TODO: [TDD] Passo 3.3 - Implementar este teste")
    void deveCriarUsuario_quandoRequisicaoEhValida() throws Exception {
        // TODO: Implemente o teste para o endpoint.
        // 1. Crie um objeto de requisição (pode ser o DTO ou um Map/String JSON).
        //    Ex: Map.of("nome", "User Test", "email", "user@test.com")
        // 2. Use o 'mockMvc' para realizar uma requisição POST para "/usuarios".
        //    - Use '.contentType(MediaType.APPLICATION_JSON)'.
        //    - Use '.content(objectMapper.writeValueAsString(requestObject))'.
        // 3. Verifique se o status da resposta é 201 Created.
        //    - '.andExpect(status().isCreated())'.
        // 4. Capture o 'CriarUsuarioInput' que foi passado para o serviço.
        //    Use 'ArgumentCaptor.forClass(CriarUsuarioInput.class)'.
        // 5. Verifique (com 'verify') se o método 'criarUsuario' do serviço foi chamado.
        // 6. Use o captor para verificar se os dados no comando correspondem aos da requisição.
    }

    @Test
    @Disabled("TODO: [TDD] Passo 3.5 - Implementar este teste de validação")
    void naoDeveCriarUsuario_quandoRequisicaoEhInvalida() throws Exception {
        // TODO: Implemente o teste de validação.
        // 1. Crie um objeto de requisição com dados inválidos (ex: nome em branco).
        // 2. Use o 'mockMvc' para realizar a requisição POST para "/usuarios".
        // 3. Verifique se o status da resposta é 400 Bad Request.
        //    - '.andExpect(status().isBadRequest())'.
    }
}
