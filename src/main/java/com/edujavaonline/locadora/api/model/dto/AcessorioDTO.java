package com.edujavaonline.locadora.api.model.dto;

import java.io.Serializable;

import com.edujavaonline.locadora.api.model.entity.Acessorio;

public class AcessorioDTO implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	private Long id;	
	
	private String descricao;
	
	public AcessorioDTO() {}	

	public AcessorioDTO(Acessorio acessorio) {
		super();
		this.id = acessorio.getId();
		this.descricao = acessorio.getDescricao();
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
