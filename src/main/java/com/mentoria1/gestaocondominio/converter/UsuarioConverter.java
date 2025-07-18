package com.mentoria1.gestaocondominio.converter;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.UsuarioRequest;
import com.mentoria1.gestaocondominio.domain.Usuario;
import org.antlr.v4.runtime.atn.PredicateTransition;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UsuarioConverter implements Function<UsuarioRequest, Usuario> {

    @Override
    public Usuario apply(UsuarioRequest request){
        var usuario = new Usuario();
        BeanUtils.copyProperties(request, usuario);
        usuario.setSenha(BCrypt.hashpw(request.senha(), BCrypt.gensalt()));
        return usuario;
    }

}
