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

import com.edujavaonline.locadora.api.model.dto.ModeloCarroDTO;
import com.edujavaonline.locadora.api.service.ModeloCarroService;

@RestController
@RequestMapping(value = "/modelosCarros")
public class ModeloCarroResource {

	@Autowired
	private ModeloCarroService modeloCarroService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ModeloCarroDTO>> findAll() {
		List<ModeloCarroDTO> dtos = modeloCarroService.findAll();
		return ResponseEntity.ok().body(dtos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ModeloCarroDTO> findById(@PathVariable Long id) {
		ModeloCarroDTO dto = modeloCarroService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		modeloCarroService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody ModeloCarroDTO modeloCarroDTO) {
		ModeloCarroDTO dto = modeloCarroService.save(modeloCarroDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ModeloCarroDTO dto) {
		modeloCarroService.update(id, dto);
		return ResponseEntity.ok().build();
	}
}
