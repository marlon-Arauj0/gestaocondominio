package com.mentoria1.gestaocondominio.service.impl;

import com.mentoria1.gestaocondominio.converter.DespesaConverter;
import com.mentoria1.gestaocondominio.dataTransferObjectDTO.DespesaRequest;
import com.mentoria1.gestaocondominio.domain.Despesa;
import com.mentoria1.gestaocondominio.domain.enums.StatusDespesa;
import com.mentoria1.gestaocondominio.repository.DespesaRepository;
import com.mentoria1.gestaocondominio.service.DespesaService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaServiceImpl implements DespesaService {

    private final DespesaConverter converter;

    private final DespesaRepository repository;

    @Override
    public void cadastrar(DespesaRequest request) {
        var despesa = converter.convert(request);
        repository.save(despesa);
    }

    @Override
    public List<Despesa> listar() {
        return repository.findAll();
    }

    @Override
    public Despesa buscarById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Despesa> listar(String status) {
        if (StringUtils.isBlank(status))
            return listar();

        var statusDespesas = StatusDespesa.valueOf(status);
        return repository.findAllByStatus(statusDespesas);
    }
}