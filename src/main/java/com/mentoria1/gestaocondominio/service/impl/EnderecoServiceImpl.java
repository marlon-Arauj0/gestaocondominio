package com.mentoria1.gestaocondominio.service.impl;

import com.mentoria1.gestaocondominio.client.BrazilAPIClient;
import com.mentoria1.gestaocondominio.converter.EnderecoUnidadeConverter;
import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.UnidadeEnderecoRequest;
import com.mentoria1.gestaocondominio.repository.EnderecoRepository;
import com.mentoria1.gestaocondominio.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoUnidadeConverter converter;

    @Override
    public void cadastrarEnderecoUnidade(UnidadeEnderecoRequest request) {
        var enderecoUnidade = converter.converter(request);
        repository.save(enderecoUnidade);
    }
}
