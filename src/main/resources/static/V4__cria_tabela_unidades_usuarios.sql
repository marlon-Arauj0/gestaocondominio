DROP TABLE IF EXISTS unidades_usuarios;
--Observação : Tenha cuidado antes de excluir uma tabela. Excluir uma tabela resultará na perda de todas as informações armazenadas nela!

CREATE TABLE unidades_usuarios(
	id_unidade	BIGINT	NOT NULL ,
	id_usuario	BIGINT	NOT NULL ,

	PRIMARY KEY(id_unidade, id_usuario),
	FOREIGN KEY(id_unidade) REFERENCES unidades(id),
	FOREIGN KEY(id_usuario) REFERENCES usuarios(id)
);
