package com.mentoria1.gestaocondominio.controller;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.DespesaRequest;
import com.mentoria1.gestaocondominio.domain.Despesa;
import com.mentoria1.gestaocondominio.service.DespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/Despesa")
public class DespesaController {

    private final DespesaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDespesa(@RequestBody DespesaRequest request) {
        service.cadastrar(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> ListarDespesas(){
        return service.listar();
    }

    @GetMapping("filtro")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> ListarDespesasFiltro(@RequestParam(value = "status", required = false) String status){
        return service.listar(status);
    }

    @GetMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Despesa getDespesaById(@PathVariable Long id){
        return service.buscarById(id);
    }
}