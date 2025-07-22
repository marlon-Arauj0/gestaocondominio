package com.mentoria1.gestaocondominio.exception;

public class ReceitaNotFoundException extends RuntimeException {
    public ReceitaNotFoundException() {
        super("receita não encontrada");
    }
}
