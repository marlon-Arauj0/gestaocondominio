package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.ReceitaRequest;
import com.mentoria1.gestaocondominio.domain.Receita;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ReceitaService {

    void cadastrar(ReceitaRequest request);

    Receita buscarById(Long id);

    List<Receita> listarTodas();

}
