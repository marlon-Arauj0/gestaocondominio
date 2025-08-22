package com.mentoria1.gestaocondominio.converter;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.UsuarioRequest;
import com.mentoria1.gestaocondominio.domain.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

@Component
public class UsuarioConverter implements Function<UsuarioRequest, Usuario> {

    @Override
    public Usuario apply(UsuarioRequest request){
        var usuario = new Usuario();

        BeanUtils.copyProperties(request, usuario);

        usuario.setSenha(BCrypt.hashpw(request.senha(), BCrypt.gensalt()));
        usuario.setDataCriacao(LocalDateTime.now());

        return usuario;
    }

}
