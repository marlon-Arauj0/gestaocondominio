package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.DespesaRequest;
import com.mentoria1.gestaocondominio.domain.Despesa;

import java.util.List;

public interface DespesaService {

    void  cadastrar(DespesaRequest request);

    List<Despesa> listar();

    Despesa buscarById(Long id);

}
