package com.edujavaonline.locadora.api.model.enuns;

public enum Categoria {

	HATCH_COMPACTO("Hatch Compacto"),
	HATCH_MEDIO("Hatch Médio"),
	SEDAN_COMPACTO("Sedã Compacto"),
	SEDAN_MEDIO("Sedã Médio"),
	SEDAN_GRANDE("Sedã Grande"),
	PERUA("Perua"),
	PICAPE("Picape"),
	SUV("SUV"),
	MINIVAN("Minivan"),
	ESPORTIVO("Esportivo"),
	UTILITARIO_COMERCIAL("Utilitário Comercial");
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
	private Categoria(String descricao) {
		this.descricao = descricao;
	}
}
