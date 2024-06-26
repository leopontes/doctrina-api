package br.com.doctrina.spring.support;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.doctrina.dto.DTO;

public interface ICrudService<T> {
	
	Optional<T> save(DTO dto);
	Optional<T> update(DTO dto);
	Optional<T> get(Long id);
	
	Page<T> findAll(Specification<T> specification, Pageable pageable);
	
	Collection<T> listAll();
	Collection<T> listBy(Specification<T> specification);
	
	void delete(Long id);
}
