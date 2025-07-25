package com.mentoria1.gestaocondominio.service.impl;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.AutenticacaoRequest;
import com.mentoria1.gestaocondominio.domain.Usuario;
import com.mentoria1.gestaocondominio.exception.SemAutorizacaoException;
import com.mentoria1.gestaocondominio.exception.UsuarioNotFoundException;
import com.mentoria1.gestaocondominio.service.AutenticacaoService;
import com.mentoria1.gestaocondominio.service.JWTService;
import com.mentoria1.gestaocondominio.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacaoServiceImpl implements AutenticacaoService {

    private final JWTService jwtService;
    private final UsuarioService usuarioService;

    @Override
    public String gerarToken(AutenticacaoRequest request) {
        try {
            var usuario = usuarioService.obterUsuario(request.email());
            validarSenha(usuario, request);
            return jwtService.gerarTokenJWT(usuario);
        } catch (UsuarioNotFoundException e){
            throw new SemAutorizacaoException("Credenciais invalidas");
        }
    }

    private void validarSenha(Usuario usuario, AutenticacaoRequest request){
        var isSenhaInvalida = !BCrypt.checkpw(request.senha(), usuario.getSenha());
         if (isSenhaInvalida)
             throw new SemAutorizacaoException("Credenciais invalidas");
    }

}
