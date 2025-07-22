package com.mentoria1.gestaocondominio.converter;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.ReceitaRequest;
import com.mentoria1.gestaocondominio.domain.Receita;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.mentoria1.gestaocondominio.utils.DataUtil.stringToLocalDate;

@Component
public class ReceitaConverter {
    public Receita converter(ReceitaRequest request){

        Receita receita = new Receita();
        BeanUtils.copyProperties(request, receita);

        receita.setDataPagamento(stringToLocalDate(request.dataPagamento()));
        receita.setDataVencimento(stringToLocalDate(request.dataVencimento()));
        receita.setDataCriacao(LocalDateTime.now());

        return receita;
    }
}
