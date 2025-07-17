DROP TABLE IF EXISTS usuarios;
--Observação : Tenha cuidado antes de excluir uma tabela. Excluir uma tabela resultará na perda de todas as informações armazenadas nela!

CREATE TABLE usuarios (
    id              BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    id_unidade      BIGINT          NOT NULL                            ,
    nome            VARCHAR(255)    NOT NULL                            ,
    email           VARCHAR(255)    NOT NULL UNIQUE                     ,
    senha           VARCHAR(255)    NOT NULL                            ,
    admin           BOOLEAN         NOT NULL DEFAULT false              ,
    CONSTRAINT fk_usuarios_unidades FOREIGN KEY (id_unidade) REFERENCES unidades(id)
);
