package com.mentoria1.gestaocondominio.service.impl;

import com.mentoria1.gestaocondominio.client.BrazilAPIClient;
import com.mentoria1.gestaocondominio.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final BrazilAPIClient brazilAPIClient;
    @Override
    public void cadastrarEnderecoUnidade() {
        var endereco = brazilAPIClient;
    }
}
