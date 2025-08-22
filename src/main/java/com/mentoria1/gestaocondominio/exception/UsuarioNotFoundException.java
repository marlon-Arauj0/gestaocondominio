package com.mentoria1.gestaocondominio.exception;

import static com.mentoria1.gestaocondominio.utils.AppMenssages.USER_NOT_FOUND;

public class    UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException() {
        super(USER_NOT_FOUND);
    }
}
