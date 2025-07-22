package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.UnidadeRequest;
import com.mentoria1.gestaocondominio.domain.Unidade;

public interface UnidadeService {

    void criar(UnidadeRequest request);

    Unidade buscarPorId(Long id);
}
