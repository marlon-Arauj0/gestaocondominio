package com.mentoria1.gestaocondominio.domain;

import com.mentoria1.gestaocondominio.domain.enums.StatusDespesa;

import java.time.LocalDate;

public class Despesa {

    private Integer id;
    private String categoria;
    private String discricao;
    private Double valorOriginal;
    private Double valorPago;
    private LocalDate dataCriacao;
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;
    private StatusDespesa status;
}
