package com.mentoria1.gestaocondominio.controller;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.UnidadeEnderecoRequest;
import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.UnidadeRequest;
import com.mentoria1.gestaocondominio.oauth.PreAutorizado;
import com.mentoria1.gestaocondominio.service.EnderecoService;
import com.mentoria1.gestaocondominio.service.UnidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/Unidade")
public class UnidadeController {

    private final UnidadeService unidadeService;
    private final EnderecoService enderecoService;

    @PreAutorizado
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody UnidadeRequest request){
        unidadeService.criar(request);
    }

    @PreAutorizado
    @PostMapping("endereco")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarEnderecoUnidade(@RequestBody UnidadeEnderecoRequest request) {
        enderecoService.cadastrarEnderecoUnidade(request);
    }
}
