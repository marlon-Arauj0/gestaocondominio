package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.domain.Usuario;

public interface JWTService {

    String gerarTokenJWT(Usuario usuario);

    String validarTokenAndGetEmailUsuario(String token);
}
