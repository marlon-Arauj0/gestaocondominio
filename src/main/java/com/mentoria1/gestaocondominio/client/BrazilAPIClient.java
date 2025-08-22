package com.mentoria1.gestaocondominio.client;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Response.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brazilAPI" , url = "https://brasilapi.com.br")
public interface BrazilAPIClient {
    @GetMapping("api/cep/v2/{cep}")
    EnderecoResponse getEnderecoPorCep(@PathVariable(name = "cep")String cep);
}
