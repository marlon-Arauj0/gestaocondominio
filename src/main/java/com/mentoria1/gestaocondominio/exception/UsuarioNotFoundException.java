package com.mentoria1.gestaocondominio.exception;

public class    UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException() {
        super("Usuario não encontrado");
    }
}
