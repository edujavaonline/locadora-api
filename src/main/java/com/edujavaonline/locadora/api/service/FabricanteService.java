package com.edujavaonline.locadora.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edujavaonline.locadora.api.model.dto.FabricanteDTO;
import com.edujavaonline.locadora.api.model.entity.Fabricante;
import com.edujavaonline.locadora.api.repository.FabricanteRepository;
import com.edujavaonline.locadora.api.service.exception.ObjectNotFoundException;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public List<FabricanteDTO> findAll() {		
		List<Fabricante> entities = fabricanteRepository.findAll();			
		if(entities.isEmpty() ) {
			throw new ObjectNotFoundException("Não existem Fabricantes cadastrados!");
		} else {
			 return entities.stream().map(e -> new FabricanteDTO(e)).collect(Collectors.toList());
		}		
	}
	
	public FabricanteDTO findById(Long id) {
		Optional<Fabricante> one = fabricanteRepository.findById(id);
		Fabricante entity = one.orElseThrow(() -> new ObjectNotFoundException("Fabricante não encontrado!"));
		return new FabricanteDTO(entity);		 		
	}	
	
	public void delete(Long id) {
		findById(id);
		fabricanteRepository.deleteById(id);
	}
	
	public FabricanteDTO save(FabricanteDTO dto) {
		Fabricante entity = fromDTO(dto);
		return new FabricanteDTO(fabricanteRepository.save(entity));		
	}
	
	public void update(Long id, FabricanteDTO fabricanteDTO) {
		FabricanteDTO dto = findById(id);	
		Fabricante entity = fromDTO(dto);
		BeanUtils.copyProperties(fabricanteDTO, entity, "id");				
		fabricanteRepository.save(entity);		
	}
	
	private Fabricante fromDTO(FabricanteDTO dto) {
		return new Fabricante(dto.getId(), dto.getDescricao());
	}
}
