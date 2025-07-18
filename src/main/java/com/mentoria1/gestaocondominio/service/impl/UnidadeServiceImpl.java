package com.mentoria1.gestaocondominio.service.impl;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.UnidadeRequest;
import com.mentoria1.gestaocondominio.domain.Unidade;
import com.mentoria1.gestaocondominio.repository.UnidadeRepository;
import com.mentoria1.gestaocondominio.service.UnidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnidadeServiceImpl implements UnidadeService {

    private final UnidadeRepository repository;

    @Override
    public void criar(UnidadeRequest request) {
        var unidade = new Unidade();
        BeanUtils.copyProperties(request, unidade);
        repository.save(unidade);
    }
}
