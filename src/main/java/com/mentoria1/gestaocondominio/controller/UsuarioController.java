package com.mentoria1.gestaocondominio.controller;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.UsuarioRequest;
import com.mentoria1.gestaocondominio.domain.Usuario;
import com.mentoria1.gestaocondominio.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/Usuario")
public class UsuarioController  {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody @Valid UsuarioRequest request){
        service.criar(request);
    }

    @GetMapping("{email}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario getUsuarioByEmail(@PathVariable String email){
        return service.obterEmail(email);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarSenha(@RequestParam String email,
                               @RequestParam String senha) {
        service.atualizarSenha(email, senha);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associarUnidade(@RequestParam String email,
                                @RequestParam String registro){
        service.associarUnidade(email, registro);
    }
}
