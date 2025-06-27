package com.mentoria1.gestaocondominio.dataTransferObjectDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class DespesaRequest {

    private String categoria;
    private String descricao;
    private Double valorOriginal;
    private Double valorPago;
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;

}
