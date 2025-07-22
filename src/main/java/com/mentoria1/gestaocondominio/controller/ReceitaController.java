package com.mentoria1.gestaocondominio.controller;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.ReceitaRequest;
import com.mentoria1.gestaocondominio.domain.Receita;
import com.mentoria1.gestaocondominio.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/Receita")
public class ReceitaController {

    public final ReceitaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastrarReceita(@RequestBody ReceitaRequest request){
        service.cadastrar(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Receita> listarTodasReceitas(){
        return service.listarTodas();
    }
    @GetMapping(value = "{id}" /*, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE**/ )
    @ResponseStatus(HttpStatus.OK)
    public Receita buscarPorId(@PathVariable Long id){
        return service.buscarById(id);
    }

}
