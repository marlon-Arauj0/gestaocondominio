package com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request;

import com.mentoria1.gestaocondominio.domain.Unidade;

public record UnidadeEnderecoRequest (Long unidadeId,
                                     String cep,
                                     String numero,
                                     String complemento) {}
