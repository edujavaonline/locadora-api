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

import com.edujavaonline.locadora.api.model.dto.AcessorioDTO;
import com.edujavaonline.locadora.api.service.AcessorioService;

@RestController
@RequestMapping(value = "/acessorios")
public class AcessorioResource {

	@Autowired
	private AcessorioService acessorioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AcessorioDTO>> findAll() {
		List<AcessorioDTO> dtos = acessorioService.findAll();	
		return ResponseEntity.ok().body(dtos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AcessorioDTO> findById(@PathVariable Long id) {
		AcessorioDTO dto = acessorioService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		acessorioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody AcessorioDTO acessorioDTO) {
		AcessorioDTO dto = acessorioService.save(acessorioDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody AcessorioDTO dto) {
		acessorioService.update(id, dto);
		return ResponseEntity.ok().build();
	}
}
