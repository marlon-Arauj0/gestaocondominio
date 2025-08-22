package com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request;

public record ReceitaRequest(
        String categoria,
        Double valor,
        String descricao,
        String dataPagamento,
        String dataVencimento,
        Long idUnidade) {}
