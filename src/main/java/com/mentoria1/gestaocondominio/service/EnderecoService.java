package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.UnidadeEnderecoRequest;
import org.springframework.stereotype.Service;

@Service
public interface EnderecoService {

    void cadastrarEnderecoUnidade(UnidadeEnderecoRequest request);
}
