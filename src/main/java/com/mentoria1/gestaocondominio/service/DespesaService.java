package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.DespesaRequest;
import com.mentoria1.gestaocondominio.domain.Despesa;

public interface DespesaService {

    void  cadastrar(DespesaRequest request);

}
