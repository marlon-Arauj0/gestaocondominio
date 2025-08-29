package com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request;

public record UnidadeEnderecoRequest (Long unidadeId,
                                     String cep,
                                     String numero,
                                     String complemento) {}
