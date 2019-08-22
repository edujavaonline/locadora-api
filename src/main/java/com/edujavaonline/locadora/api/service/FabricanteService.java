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
		List<Fabricante> fabricantes = fabricanteRepository.findAll();			
		if(fabricantes.isEmpty() ) {
			throw new ObjectNotFoundException("Não existem Fabricantes cadastrados!");
		} else {
			 return fabricantes.stream().map(f -> new FabricanteDTO(f)).collect(Collectors.toList());
		}		
	}
	
	public FabricanteDTO findById(Long id) {
		Optional<Fabricante> fabricanteRetornado = fabricanteRepository.findById(id);
		Fabricante fabricante = fabricanteRetornado.orElseThrow(() -> new ObjectNotFoundException("Fabricante não encontrado!"));
		return new FabricanteDTO(fabricante);		 		
	}	
	
	public void delete(Long id) {
		findById(id);
		fabricanteRepository.deleteById(id);
	}
	
	public FabricanteDTO save(FabricanteDTO fabricanteDTO) {
		Fabricante fabricante = fromDTO(fabricanteDTO);
		return new FabricanteDTO(fabricanteRepository.save(fabricante));		
	}
	
	public FabricanteDTO update(Long id, FabricanteDTO fabricanteDTO) {
		FabricanteDTO dto = findById(id);	
		Fabricante fabricante = fromDTO(dto);
		BeanUtils.copyProperties(fabricanteDTO, fabricante, "id");				
		return new FabricanteDTO(fabricanteRepository.save(fabricante));		
	}
	
	private Fabricante fromDTO(FabricanteDTO fabricanteDTO) {
		return new Fabricante(fabricanteDTO.getId(), fabricanteDTO.getDescricao());
	}
}
