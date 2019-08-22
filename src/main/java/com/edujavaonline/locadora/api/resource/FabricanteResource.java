package com.edujavaonline.locadora.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edujavaonline.locadora.api.model.dto.FabricanteDTO;
import com.edujavaonline.locadora.api.service.FabricanteService;

@RestController
@RequestMapping(value = "/fabricantes")
public class FabricanteResource {
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FabricanteDTO>> findAll() {
		List<FabricanteDTO> fabricantesDTO = fabricanteService.findAll();		 
		return ResponseEntity.ok().body(fabricantesDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FabricanteDTO> findById(@PathVariable Long id) {
		FabricanteDTO fabricanteDTO = fabricanteService.findById(id);		
		return ResponseEntity.ok().body(fabricanteDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		fabricanteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody FabricanteDTO fabricanteDTO) {
		FabricanteDTO dto = fabricanteService.save(fabricanteDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody FabricanteDTO fabricanteDTO, @PathVariable Long id) {		
		fabricanteService.update(id, fabricanteDTO);			
		return ResponseEntity.ok().build();
	}


}
