package br.com.doctrina.repository;

import org.springframework.stereotype.Repository;

import br.com.doctrina.entity.Grupo;
import br.com.doctrina.spring.support.ICrudRepository;

@Repository
public interface GrupoRepository extends ICrudRepository<Grupo>{

}
