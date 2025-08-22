package com.mentoria1.gestaocondominio.service.impl;

import com.mentoria1.gestaocondominio.converter.UsuarioConverter;
import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.UsuarioRequest;
import com.mentoria1.gestaocondominio.domain.Usuario;
import com.mentoria1.gestaocondominio.exception.AssociacaoUsuarioUnidadeException;
import com.mentoria1.gestaocondominio.exception.CriacaoException;
import com.mentoria1.gestaocondominio.exception.UsuarioNotFoundException;
import com.mentoria1.gestaocondominio.repository.UnidadeRepository;
import com.mentoria1.gestaocondominio.repository.UsuarioRepository;
import com.mentoria1.gestaocondominio.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import static com.mentoria1.gestaocondominio.utils.AppMenssages.*;
import static com.mentoria1.gestaocondominio.utils.AppUtil.isEmailInvalid;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository repository;
    private final UnidadeRepository unidadeRepository;
    private final UsuarioConverter converter;

    @Override
    public void criar(UsuarioRequest request) {
        validarEmail(request);
        Usuario usuario =  converter.apply(request);
        salvarUsuario(usuario);
    }

    @Override
    public Usuario obterUsuario(String email) {
        return repository
                .findByEmail(email)
                .orElseThrow(UsuarioNotFoundException::new);
    }

    @Override
    public Usuario obterUsuario(Long idUsuario) {
        return repository
                .findById(idUsuario)
                .orElseThrow(UsuarioNotFoundException::new);
    }

    @Override
    public void atualizarSenha(String email, String novaSenha) {
        var usuario = obterUsuario(email);
        var senha = BCrypt.hashpw(novaSenha, BCrypt.gensalt());
        usuario.setSenha(senha);
        salvarUsuario(usuario);
    }

    @Override
    public void associarUnidade(String emailUsuario, String registroUnidade) {
        var usuario = repository
                .findByEmail(emailUsuario)
                .orElseThrow(()-> new AssociacaoUsuarioUnidadeException(USER_NOT_FOUND));

        var unidade = unidadeRepository
                .findFirstByregistro(registroUnidade)
                .orElseThrow(()-> new AssociacaoUsuarioUnidadeException(UNIT_NOT_FOUND));

        unidade.setUsuario(usuario);
        unidadeRepository.save(unidade);
    }

    private void validarEmail (UsuarioRequest request){
        if (isEmailInvalid(request.email())){
            throw new CriacaoException(CANNOT_BE_NULL_OR_BLANK);
        }
    }
    private void salvarUsuario (Usuario usuario){
        try {
            repository.save(usuario);
        } catch (Exception e) {
            throw new CriacaoException(EMAIL_ALREADY_EXISTS + e.getMessage());
        }
    }
}