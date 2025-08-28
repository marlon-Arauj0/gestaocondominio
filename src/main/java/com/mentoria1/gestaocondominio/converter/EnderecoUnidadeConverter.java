package com.mentoria1.gestaocondominio.converter;

import com.mentoria1.gestaocondominio.client.BrazilAPIClient;
import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.UnidadeEnderecoRequest;
import com.mentoria1.gestaocondominio.domain.Endereco;
import com.mentoria1.gestaocondominio.oauth.UsuarioAppContext;
import com.mentoria1.gestaocondominio.service.UnidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoUnidadeConverter {

    private final UsuarioAppContext usuarioAppContext;
    private final UnidadeService unidadeService;
    private final BrazilAPIClient brazilAPIClient;

    public Endereco converter(UnidadeEnderecoRequest request){
        var endereco = brazilAPIClient.getEnderecoPorCep(request.cep());

        Endereco enderecoUnidade = new Endereco();
        BeanUtils.copyProperties(request, enderecoUnidade);

        var unidade = unidadeService.buscarPorId(request.unidadeId());
        enderecoUnidade.setUsuario(usuarioAppContext.getUsuario());
        enderecoUnidade.setUnidade(unidade);
        enderecoUnidade.setLogradouro(endereco.getStreet());
        enderecoUnidade.setUf(endereco.getState());
        enderecoUnidade.setBairro(endereco.getNeighborhood());
        enderecoUnidade.setCidade(endereco.getCity());

        return enderecoUnidade;
    }
}