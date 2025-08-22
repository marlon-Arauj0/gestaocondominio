package com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request;

public record DespesaRequest(
        String categoria,
        String descricao,
        Double valorOriginal,
        Double valorPago,
        String dataPagamento,
        String dataVencimento
) {}
