package br.com.doctrina.controller;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.doctrina.dto.PerfilDTO;
import br.com.doctrina.service.GrupoService;
import br.com.doctrina.spring.exception.NotFoundException;

@RestController
@RequestMapping("/v1/grupo")
public class GrupoController {

	@Autowired
	GrupoService service;
	
	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/{id}")
	public Optional<PerfilDTO> findById(@PathVariable Long id) {
		return service.get(id)
				      .map(e->modelMapper.map(e, PerfilDTO.class));
	}
	
	@GetMapping
	public Collection<PerfilDTO> findAll(){
		return service.listAll()
				      .stream()
				      .map(e->modelMapper.map(e, PerfilDTO.class))
				      .toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Optional<PerfilDTO> create(@RequestBody final PerfilDTO dto) {
		
		if(Objects.isNull(dto)) {
			throw new NotFoundException("Recurso não encontado.");
		}
		
		return service.save(dto)
					  .map(e->modelMapper.map(e, PerfilDTO.class));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<PerfilDTO> update(@PathVariable Long id, @RequestBody final PerfilDTO dto) {
		
		if(service.get(id).isEmpty()) {
			throw new NotFoundException("Recurso não encontado.");
		}
		
		return service.update(dto)
					  .map(e->modelMapper.map(e, PerfilDTO.class));
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
