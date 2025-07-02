package com.mentoria1.gestaocondominio.dataTransferObjectDTO;

import java.time.LocalDate;

public record DespesaRequest(
        String categoria,
        String descricao,
        Double valorOriginal,
        Double valorPago,
        String dataPagamento,
        String dataVencimento
) {}
