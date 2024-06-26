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

import br.com.doctrina.dto.UsuarioDTO;
import br.com.doctrina.service.UsuarioService;
import br.com.doctrina.spring.exception.NotFoundException;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/{id}")
	public Optional<UsuarioDTO> findById(@PathVariable Long id) {
		return service.get(id)
				      .map(e->modelMapper.map(e, UsuarioDTO.class));
	}
	
	@GetMapping
	public Collection<UsuarioDTO> findAll(){
		return service.listAll()
				      .stream()
				      .map(e->modelMapper.map(e, UsuarioDTO.class))
				      .toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Optional<UsuarioDTO> create(@RequestBody final UsuarioDTO dto) {
		
		if(Objects.isNull(dto)) {
			throw new NotFoundException("Recurso não encontado.");
		}
		
		return service.save(dto)
					  .map(e->modelMapper.map(e, UsuarioDTO.class));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<UsuarioDTO> update(@PathVariable Long id, @RequestBody final UsuarioDTO dto) {
		
		if(service.get(id).isEmpty()) {
			throw new NotFoundException("Recurso não encontado.");
		}
		
		return service.update(dto)
					  .map(e->modelMapper.map(e, UsuarioDTO.class));
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
