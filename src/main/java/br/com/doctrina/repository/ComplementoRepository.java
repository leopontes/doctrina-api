package br.com.doctrina.repository;

import org.springframework.stereotype.Repository;

import br.com.doctrina.entity.Complemento;
import br.com.doctrina.spring.support.ICrudRepository;

@Repository
public interface ComplementoRepository extends ICrudRepository<Complemento>{

}
