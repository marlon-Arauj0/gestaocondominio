package com.mentoria1.gestaocondominio.converter;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request.ReceitaRequest;
import com.mentoria1.gestaocondominio.domain.Receita;
import com.mentoria1.gestaocondominio.oauth.UsuarioAppContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.mentoria1.gestaocondominio.utils.DataUtil.stringToLocalDate;

@Component
@RequiredArgsConstructor
public class ReceitaConverter {

    private final UsuarioAppContext usuarioAppContext;

    public Receita converter(ReceitaRequest request){

        Receita receita = new Receita();
        BeanUtils.copyProperties(request, receita);

        receita.setUsuario(usuarioAppContext.getUsuario());
        receita.setDataPagamento(stringToLocalDate(request.dataPagamento()));
        receita.setDataVencimento(stringToLocalDate(request.dataVencimento()));
        receita.setDataCriacao(LocalDateTime.now());

        return receita;
    }
}
