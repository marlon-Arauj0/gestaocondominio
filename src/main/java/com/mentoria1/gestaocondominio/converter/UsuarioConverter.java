package com.mentoria1.gestaocondominio.converter;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.UsuarioRequest;
import com.mentoria1.gestaocondominio.domain.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UsuarioConverter implements Function<UsuarioRequest, Usuario> {

    @Override
    public Usuario apply(UsuarioRequest request){

        var senha = BCrypt.hashpw(request.senha(), BCrypt.gensalt());

        var usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(senha);

        return usuario;
    }

}
