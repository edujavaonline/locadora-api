package com.edujavaonline.locadora.api.model.dto;

import java.io.Serializable;

import com.edujavaonline.locadora.api.model.entity.Fabricante;

public class FabricanteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String descricao;
	
	public FabricanteDTO() {}
	
	public FabricanteDTO(Fabricante fabricante) {
		super();
		this.id = fabricante.getId();
		this.descricao = fabricante.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
