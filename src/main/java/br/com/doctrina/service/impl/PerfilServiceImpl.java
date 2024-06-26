package br.com.doctrina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctrina.dto.DTO;
import br.com.doctrina.dto.PerfilDTO;
import br.com.doctrina.entity.Perfil;
import br.com.doctrina.repository.PerfilRepository;
import br.com.doctrina.service.PerfilService;
import br.com.doctrina.spring.support.ICrudRepository;

@Service
public class PerfilServiceImpl extends AbstractCrudServiceImpl<Perfil> implements PerfilService{

	@Autowired
	PerfilRepository repository;
	
	@Override
	public ICrudRepository<Perfil> getRepository() {
		return repository;
	}

	@Override
	public DTO toDTO(Perfil entity) {
		return getModelMapper().map(entity, PerfilDTO.class);
	}

	@Override
	public Perfil toEntity(DTO dto) {
		return getModelMapper().map(dto, Perfil.class);
	}

}
