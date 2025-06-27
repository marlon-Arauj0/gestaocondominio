package com.mentoria1.gestaocondominio.controller;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.DespesaRequest;
import com.mentoria1.gestaocondominio.service.DespesaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Despesa")
public class DespesaController {

    private DespesaService service;

    @PostMapping
    public void cadastrarDespesa(@RequestBody DespesaRequest request) {
        service.cadastrar(request);
    }

}
