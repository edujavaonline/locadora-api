CREATE TABLE tb_acessorio
(
  id SERIAL      NOT NULL,  
  descricao 	VARCHAR(100) NOT NULL,   

  CONSTRAINT pk_acessorio PRIMARY KEY (id)
);

INSERT INTO tb_acessorio (descricao) VALUES ('Vidros Elétricos');
INSERT INTO tb_acessorio (descricao) VALUES ('Travas Elétricas');
INSERT INTO tb_acessorio (descricao) VALUES ('Kit Multimídia');
INSERT INTO tb_acessorio (descricao) VALUES ('Ar Condicionado');
INSERT INTO tb_acessorio (descricao) VALUES ('Banco de Couro');