package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.UsuarioRequest;
import com.mentoria1.gestaocondominio.domain.Usuario;


public interface UsuarioService {

    void criar (UsuarioRequest request);

    Usuario obterUsuario(String email);

    Usuario obterUsuario(Long idUsuario);

    void atualizarSenha(String email, String novaSenha);

    void associarUnidade(String emailUsuario, String registroUnidade);
}
