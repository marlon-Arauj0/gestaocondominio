DROP TABLE IF EXISTS unidades;
--Observação : Tenha cuidado antes de excluir uma tabela. Excluir uma tabela resultará na perda de todas as informações armazenadas nela!

CREATE TABLE unidades (
    id          BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    id_usuarios BIGINT          NULL                                ,
    tipo        VARCHAR(50)     NOT NULL                            ,
    registro    VARCHAR(300)    NOT NULL UNIQUE
);