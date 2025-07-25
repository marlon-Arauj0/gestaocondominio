package com.mentoria1.gestaocondominio.controller;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.AutenticacaoRequest;
import com.mentoria1.gestaocondominio.service.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/Autenticacao")
public class AutenticacaoController {

    private final AutenticacaoService service;

    @PostMapping("gerar-token")
    @ResponseStatus(HttpStatus.OK)
    public String loginSistema(@RequestBody AutenticacaoRequest request){
        return service.gerarToken(request);
    }
}
