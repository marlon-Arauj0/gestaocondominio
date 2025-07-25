package com.mentoria1.gestaocondominio.exception;

public class SemAutorizacaoException extends RuntimeException {
        public SemAutorizacaoException(String message) {
        super(message);
    }
}
