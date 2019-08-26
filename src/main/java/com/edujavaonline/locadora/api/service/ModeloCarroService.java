package com.edujavaonline.locadora.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edujavaonline.locadora.api.model.dto.ModeloCarroDTO;
import com.edujavaonline.locadora.api.model.entity.Fabricante;
import com.edujavaonline.locadora.api.model.entity.ModeloCarro;
import com.edujavaonline.locadora.api.repository.ModeloCarroRepository;
import com.edujavaonline.locadora.api.service.exception.ObjectNotFoundException;

@Service
public class ModeloCarroService {

	@Autowired
	private ModeloCarroRepository modeloCarroRepository;
	
	public List<ModeloCarroDTO> findAll() {
		List<ModeloCarro> entities = modeloCarroRepository.findAll();
		if(entities.isEmpty()) {
			throw new ObjectNotFoundException("Não existem Modelos de Carros cadastrados!");
		} else {
			return entities.stream().map(e -> new ModeloCarroDTO(e)).collect(Collectors.toList());
		}
	}
	
	public ModeloCarroDTO findById(Long id) {
		Optional<ModeloCarro> one = modeloCarroRepository.findById(id);
		ModeloCarro entity = one.orElseThrow(() -> new ObjectNotFoundException("Modelo de Carro não encontrado!"));
		return new ModeloCarroDTO(entity);
	}
	
	public void delete(Long id) {
		findById(id);
		modeloCarroRepository.deleteById(id);
	}
	
	public ModeloCarroDTO save(ModeloCarroDTO dto) {
		ModeloCarro entity = fromDTO(dto);
		return new ModeloCarroDTO(modeloCarroRepository.save(entity));
	}	
	
	public ModeloCarroDTO update(Long id, ModeloCarroDTO modeloCarroDTO) {
		ModeloCarroDTO dto = findById(id);
		ModeloCarro entity = fromDTO(dto);
		BeanUtils.copyProperties(modeloCarroDTO, entity, "id");
		BeanUtils.copyProperties(modeloCarroDTO.getFabricante(), entity.getFabricante());		
		return new ModeloCarroDTO(modeloCarroRepository.save(entity));
	}	
	
	private ModeloCarro fromDTO(ModeloCarroDTO dto) {
		ModeloCarro entity = new ModeloCarro(dto.getId(), dto.getDescricao(), dto.getTipoCategoria(), null);
		entity.setFabricante(new Fabricante());
		BeanUtils.copyProperties(dto, entity, "fabricante");
		BeanUtils.copyProperties(dto.getFabricante(), entity.getFabricante());
		return entity;
	}
}
