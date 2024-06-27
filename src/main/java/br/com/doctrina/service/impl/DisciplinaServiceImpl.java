package br.com.doctrina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctrina.dto.DTO;
import br.com.doctrina.entity.Disciplina;
import br.com.doctrina.repository.DisciplinaRepository;
import br.com.doctrina.service.DisciplinaService;
import br.com.doctrina.spring.support.ICrudRepository;

@Service
public class DisciplinaServiceImpl extends AbstractCrudServiceImpl<Disciplina> implements DisciplinaService{

	@Autowired
	DisciplinaRepository repository;
	
	@Override
	public ICrudRepository<Disciplina> getRepository() {
		return repository;
	}

	@Override
	public DTO toDTO(Disciplina entity) {
		return modelMapper.map(entity, DTO.class);
	}

	@Override
	public Disciplina toEntity(DTO entity) {
		return modelMapper.map(entity, Disciplina.class);
	}

}
