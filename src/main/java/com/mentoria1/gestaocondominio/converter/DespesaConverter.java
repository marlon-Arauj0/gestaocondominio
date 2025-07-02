package com.mentoria1.gestaocondominio.converter;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.DespesaRequest;
import com.mentoria1.gestaocondominio.domain.Despesa;
import com.mentoria1.gestaocondominio.domain.enums.StatusDespesa;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Component
public class DespesaConverter {

    private static String FORMATO_DATA_PADRAO = "dd/MM/yyyy";

    public Despesa convert(DespesaRequest request){
        Despesa despesa = new Despesa();
        despesa.setCategoria(request.categoria());
        despesa.setDescricao(request.descricao());
        despesa.setValorOriginal(request.valorOriginal());
        despesa.setValorPago(request.valorPago());
        despesa.setDataVencimento(stringToLocalDate(request.dataVencimento()));
        despesa.setDataPagamento(stringToLocalDate(request.dataPagamento()));
        despesa.setDataCriacao(LocalDateTime.now());
        despesa.setStatus(obterStatusDespesa(despesa));
        return despesa;
    }

    private LocalDate stringToLocalDate(String data) {
        if (StringUtils.isBlank(data)) return null;
        var dataFormatter = DateTimeFormatter.ofPattern(FORMATO_DATA_PADRAO);
        return LocalDate.parse(data, dataFormatter);
    }

    private StatusDespesa obterStatusDespesa(Despesa despesa) {
        if (Objects.nonNull(despesa.getDataPagamento()))
            return StatusDespesa.PAGO;

        if (despesa.getDataVencimento().isBefore(LocalDate.now()))
            return StatusDespesa.ATRASADO;

        return StatusDespesa.NAO_PAGO;
    }
}
