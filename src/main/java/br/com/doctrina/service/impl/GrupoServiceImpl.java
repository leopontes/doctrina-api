package br.com.doctrina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctrina.dto.DTO;
import br.com.doctrina.entity.Grupo;
import br.com.doctrina.repository.GrupoRepository;
import br.com.doctrina.service.GrupoService;
import br.com.doctrina.spring.support.ICrudRepository;

@Service
public class GrupoServiceImpl extends AbstractCrudServiceImpl<Grupo> implements GrupoService{

	@Autowired
	GrupoRepository repository;
	
	@Override
	public ICrudRepository<Grupo> getRepository() {
		return repository;
	}

	@Override
	public DTO toDTO(Grupo entity) {
		return getModelMapper().map(entity, DTO.class);
	}

	@Override
	public Grupo toEntity(DTO entity) {
		return getModelMapper().map(entity, Grupo.class);
	}

}
