package com.mentoria1.gestaocondominio.service.impl;

import com.mentoria1.gestaocondominio.converter.ReceitaConverter;
import com.mentoria1.gestaocondominio.dataTransferObjectDTO.ReceitaRequest;
import com.mentoria1.gestaocondominio.domain.Receita;
import com.mentoria1.gestaocondominio.domain.Unidade;
import com.mentoria1.gestaocondominio.exception.ReceitaNotFoundException;
import com.mentoria1.gestaocondominio.repository.ReceitaRepository;
import com.mentoria1.gestaocondominio.service.ReceitaService;
import com.mentoria1.gestaocondominio.service.UnidadeService;
import com.mentoria1.gestaocondominio.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceitaServiceImpl implements ReceitaService {

    private final ReceitaConverter converter;
    private final ReceitaRepository repository;
    private final UsuarioService usuarioService;
    private final UnidadeService unidadeService;

    @Override
    public void cadastrar(ReceitaRequest request) {
        var usuario = usuarioService.obterUsuario(request.idUsuario());

        Unidade unidade = null;
        if (request.idUnidade() != null) {
            unidade = unidadeService.buscarPorId(request.idUnidade());
        }

        var receita = converter.converter(request);
        repository.save(receita);
    }

    @Override
    public Receita buscarById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(ReceitaNotFoundException::new);
    }

    @Override
    public List<Receita> listarTodas() {
        return repository.findAll();
    }

}
