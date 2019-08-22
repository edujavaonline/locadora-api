CREATE TABLE tb_fabricante
(
  id SERIAL      NOT NULL,  
  descricao 	VARCHAR(100) NOT NULL,   

  CONSTRAINT pk_fabricante PRIMARY KEY (id)
);

INSERT INTO tb_fabricante (descricao) VALUES ('Chevrolet');
INSERT INTO tb_fabricante (descricao) VALUES ('Volkswagen');
INSERT INTO tb_fabricante (descricao) VALUES ('Fiat');
INSERT INTO tb_fabricante (descricao) VALUES ('Ford');
INSERT INTO tb_fabricante (descricao) VALUES ('Toyota');