package br.com.doctrina.repository;

import org.springframework.stereotype.Repository;

import br.com.doctrina.entity.Disciplina;
import br.com.doctrina.spring.support.ICrudRepository;

@Repository
public interface DisciplinaRepository extends ICrudRepository<Disciplina>{

}
