package com.mentoria1.gestaocondominio.domain;

import com.mentoria1.gestaocondominio.domain.enums.StatusDespesa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "despesas")
public class Despesa extends Domain {

    @Column(nullable = false)
    private String categoria;

    @Column(name = "valor_original", nullable = false)
    private Double valorOriginal;

    @Column(name = "valor_pago")
    private Double valorPago;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDespesa status;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
