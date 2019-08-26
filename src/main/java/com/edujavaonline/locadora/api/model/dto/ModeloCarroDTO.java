package com.edujavaonline.locadora.api.model.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.edujavaonline.locadora.api.model.entity.ModeloCarro;
import com.edujavaonline.locadora.api.model.enuns.Categoria;

public class ModeloCarroDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String descricao;
	
	private FabricanteDTO fabricante = new FabricanteDTO();
	
	private Categoria tipoCategoria;
	
	public ModeloCarroDTO() {}	
	

	public ModeloCarroDTO(ModeloCarro modeloCarro) {
		super();
		this.id = modeloCarro.getId();
		this.descricao = modeloCarro.getDescricao();		
		BeanUtils.copyProperties(modeloCarro.getFabricante(), this.fabricante);
		this.tipoCategoria = modeloCarro.getTipoCategoria();
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

	public FabricanteDTO getFabricante() {
		return fabricante;
	}

	public void setFabricante(FabricanteDTO fabricante) {
		this.fabricante = fabricante;
	}

	public Categoria getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(Categoria tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}	
}
