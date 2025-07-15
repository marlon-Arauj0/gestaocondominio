CREATE TABLE usuarios (
    id                  BIGINT               NOT NULL   PRIMARY KEY  AUTO_INCREMENT    ,
    nome                VARCHAR(255)         NOT NULL                                  ,
    email               VARCHAR(255)         NOT NULL   UNIQUE                         ,
    senha               VARCHAR(255)         NOT NULL                                  ,
    permitir_entrada    BOOLEAN              NOT NULL   DEFAULT FALSE
);