package com.mentoria1.gestaocondominio.dataTransferObjectDTO;

import jakarta.persistence.Column;

public record UsuarioRequest(String nome,
                             String email,
                             String senha,
                             Boolean permitirEntrada) {
}
