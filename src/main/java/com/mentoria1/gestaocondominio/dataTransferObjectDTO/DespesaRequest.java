package com.mentoria1.gestaocondominio.dataTransferObjectDTO;

public record DespesaRequest(
        Long idUsuario,
        String categoria,
        String descricao,
        Double valorOriginal,
        Double valorPago,
        String dataPagamento,
        String dataVencimento
) {}
