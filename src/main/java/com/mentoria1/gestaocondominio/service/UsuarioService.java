package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.UsuarioRequest;
import com.mentoria1.gestaocondominio.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    void criar (UsuarioRequest request);

    Usuario obterEmail(String email);

    void atualizarSenha(String email, String novaSenha);

}
