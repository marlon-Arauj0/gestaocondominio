package com.mentoria1.gestaocondominio.config;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.ErrorResponse;
import com.mentoria1.gestaocondominio.exception.AssociacaoUsuarioUnidadeException;
import com.mentoria1.gestaocondominio.exception.CriacaoException;
import com.mentoria1.gestaocondominio.exception.ReceitaNotFoundException;
import com.mentoria1.gestaocondominio.exception.UsuarioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(CriacaoException.class)
    public ResponseEntity<ErrorResponse> handler(CriacaoException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(UsuarioNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(ReceitaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(ReceitaNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(AssociacaoUsuarioUnidadeException.class)
    public ResponseEntity<ErrorResponse> handler(AssociacaoUsuarioUnidadeException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage()));
    }
}
