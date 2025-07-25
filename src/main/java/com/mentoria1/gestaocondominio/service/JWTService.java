package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.UsuarioPayload;
import com.mentoria1.gestaocondominio.domain.Usuario;

public interface JWTService {

    String gerarTokenJWT(Usuario usuario);

    UsuarioPayload validarToken(String token);

}
