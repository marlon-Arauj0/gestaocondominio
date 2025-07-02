package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.converter.DespesaConverter;
import com.mentoria1.gestaocondominio.dataTransferObjectDTO.DespesaRequest;
import com.mentoria1.gestaocondominio.domain.Despesa;
import com.mentoria1.gestaocondominio.domain.enums.StatusDespesa;
import com.mentoria1.gestaocondominio.repository.DespesaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class DespesaServiceImpl implements DespesaService {

    @Autowired
    private DespesaConverter converter;

    @Autowired
    private DespesaRepository repository;

    @Override
    public void cadastrar(DespesaRequest request) {
        var despesa = converter.convert(request);
        repository.save(despesa);
    }
}