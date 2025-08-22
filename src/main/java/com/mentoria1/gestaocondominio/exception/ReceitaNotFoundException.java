package com.mentoria1.gestaocondominio.exception;

import static com.mentoria1.gestaocondominio.utils.AppMenssages.TAX_REVENUE_NOT_FOUND;

public class ReceitaNotFoundException extends RuntimeException {
    public ReceitaNotFoundException() {
        super(TAX_REVENUE_NOT_FOUND);
    }
}
