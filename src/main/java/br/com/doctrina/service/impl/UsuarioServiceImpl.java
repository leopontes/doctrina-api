package br.com.doctrina.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctrina.dto.DTO;
import br.com.doctrina.entity.Usuario;
import br.com.doctrina.repository.UsuarioRepository;
import br.com.doctrina.service.UsuarioService;
import br.com.doctrina.spring.support.ICrudRepository;

@Service
public class UsuarioServiceImpl extends AbstractCrudServiceImpl<Usuario> implements UsuarioService{

	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public ICrudRepository<Usuario> getRepository() {
		return repository;
	}

	@Override
	public DTO toDTO(Usuario entity) {
		return modelMapper.map(entity, DTO.class);
	}

	@Override
	public Usuario toEntity(DTO entity) {
		return modelMapper.map(entity, Usuario.class);
	}
}
