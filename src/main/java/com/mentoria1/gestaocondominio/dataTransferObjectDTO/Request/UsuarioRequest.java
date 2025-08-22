package com.mentoria1.gestaocondominio.dataTransferObjectDTO.Request;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(@NotBlank String nome,
                             @NotBlank String email,
                             @NotBlank String senha,
                             Boolean admin) {
}
