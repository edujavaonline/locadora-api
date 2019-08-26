CREATE TABLE tb_modelo_carro
(
  id    SERIAL                NOT NULL,
  descricao 		CHARACTER VARYING(100) NOT NULL,
  tipo_categoria    CHARACTER VARYING(20) NOT NULL,
  id_fabricante 	INTEGER       NOT NULL,
  CONSTRAINT pk_modelo_carro PRIMARY KEY (id)
);
ALTER TABLE tb_modelo_carro ADD FOREIGN KEY (id_fabricante) REFERENCES tb_fabricante(id);