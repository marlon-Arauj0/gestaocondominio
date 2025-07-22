package com.mentoria1.gestaocondominio.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unidades")
public class Unidade extends Domain {

    @ManyToOne
    @JoinColumn(name = "id_usuarios")
    private Usuario usuario;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String registro;
}