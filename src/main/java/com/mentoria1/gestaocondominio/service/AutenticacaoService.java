package com.mentoria1.gestaocondominio.service;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.AutenticacaoRequest;

public interface AutenticacaoService {

        String gerarToken(AutenticacaoRequest request);
}
