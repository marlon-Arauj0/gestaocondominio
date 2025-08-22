package com.mentoria1.gestaocondominio.dataTransferObjectDTO.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoResponse {

    private String street;
    private String city;
    private String state;
    private String neighborhood;
}
