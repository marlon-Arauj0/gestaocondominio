package com.mentoria1.gestaocondominio.dataTransferObjectDTO;

public record DespesaRequest(
        String categoria,
        String descricao,
        Double valorOriginal,
        Double valorPago,
        String dataPagamento,
        String dataVencimento
) {}
