package br.com.doctrina.service.impl;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.doctrina.dto.DTO;
import br.com.doctrina.spring.support.ICrudRepository;
import br.com.doctrina.spring.support.ICrudService;
import lombok.Getter;

@Service
@Getter
public abstract class AbstractCrudServiceImpl<T> implements ICrudService<T>{

	public abstract ICrudRepository<T> getRepository();
	public abstract DTO toDTO(T entity);
	public abstract T toEntity(DTO entity);
	
	@Autowired
	protected ModelMapper modelMapper;
	
	@Override
	public Optional<T> save(DTO dto) {
		return salvar(dto);
	}
	
	@Override
	public Optional<T> update(DTO dto) {
		return salvar(dto);
	}
	
	@Override
	public void delete(Long id) {
		
		if(Objects.nonNull(id)) {
			getRepository().deleteById(id);
		}
	}
	
	@Override
	public Optional<T> get(Long id) {
		
		if(Objects.nonNull(id)) {
			return Optional.of(getRepository().getReferenceById(id));
		}
		
		return Optional.empty();
	}
	
	@Override
	public Page<T> findAll(Specification<T> specification, Pageable pageable) {
		return getRepository().findAll(specification, pageable);
	}
	
	@Override
	public Collection<T> listAll() {
		return getRepository().findAll();
	}
	
	@Override
	public Collection<T> listBy(Specification<T> specification) {
		return getRepository().findAll(specification);
	}
	
	private Optional<T> salvar(DTO dto) {
		if(Objects.nonNull(dto)) {
			return Optional.of(getRepository().save(toEntity(dto)));
		}
		
		return Optional.empty();
	}
}
