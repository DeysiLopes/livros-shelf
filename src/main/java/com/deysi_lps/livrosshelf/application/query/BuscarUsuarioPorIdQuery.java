package com.deysi_lps.livrosshelf.application.query;

public class BuscarUsuarioPorIdQuery {
    private final Long id;

    public BuscarUsuarioPorIdQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
