package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.ReceitaRequest;
import com.mentoria1.gestaocondominio.domain.Receita;

import java.util.List;

public interface ReceitaService {

    void cadastrar(ReceitaRequest request);

    Receita buscarById(Long id);

    List<Receita> listarTodas();
}
