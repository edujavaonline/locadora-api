package com.edujavaonline.locadora.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edujavaonline.locadora.api.model.dto.AcessorioDTO;
import com.edujavaonline.locadora.api.model.entity.Acessorio;
import com.edujavaonline.locadora.api.repository.AcessorioRepository;
import com.edujavaonline.locadora.api.service.exception.ObjectNotFoundException;

@Service
public class AcessorioService {

	@Autowired
	private AcessorioRepository acessorioRepository;
	
	public List<AcessorioDTO> findAll() {
		List<Acessorio> entities = acessorioRepository.findAll();
		if(entities.isEmpty()) {
			throw new ObjectNotFoundException("Não existem Acessórios cadastrados!");
		}
		return entities.stream().map(e -> new AcessorioDTO(e)).collect(Collectors.toList());
	}
	
	public AcessorioDTO findById(Long id) {
		Optional<Acessorio> one = acessorioRepository.findById(id);
		Acessorio entity = one.orElseThrow(() -> new ObjectNotFoundException("Acessório não encontrado!"));
		return new AcessorioDTO(entity);
	}
	
	public void delete(Long id) {
		findById(id);
		acessorioRepository.deleteById(id);
	}
	
	public AcessorioDTO save(AcessorioDTO dto) {
		Acessorio entity = fromDTO(dto);
		return new AcessorioDTO(acessorioRepository.save(entity));
	}
	
	public void update(Long id, AcessorioDTO acessorioDTO) {
		AcessorioDTO dto = findById(id);
		Acessorio entity = fromDTO(dto);
		BeanUtils.copyProperties(acessorioDTO, entity, "id");
		acessorioRepository.save(entity);
	}
	
	private Acessorio fromDTO(AcessorioDTO dto) {
		Acessorio entity = new Acessorio(dto.getId(), dto.getDescricao());
		return entity;
	}
}
