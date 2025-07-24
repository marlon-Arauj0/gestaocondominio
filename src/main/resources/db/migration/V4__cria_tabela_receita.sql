CREATE TABLE receitas (
    id              BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    id_unidade      BIGINT          NULL                                ,
    id_usuario      BIGINT          NOT NULL                            ,
    categoria       VARCHAR(255)    NOT NULL                            ,
    valor           DECIMAL(10, 2)  NOT NULL                            ,
    descricao       VARCHAR(255)    NOT NULL                            ,
    data_pagamento  DATE            NULL                                ,
    data_vencimento DATE            NOT NULL                            ,
    data_criacao     TIMESTAMP       NOT NULL DEFAULT NOW()             ,
    CONSTRAINT fk_receitas_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);