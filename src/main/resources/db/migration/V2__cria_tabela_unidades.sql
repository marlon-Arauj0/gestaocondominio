CREATE TABLE unidades (
    id              BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    id_usuarios     BIGINT          NULL                                ,
    tipo            VARCHAR(50)     NOT NULL                            ,
    registro        VARCHAR(300)    NOT NULL UNIQUE                     ,
    data_criacao    TIMESTAMP       NOT NULL DEFAULT NOW()
);