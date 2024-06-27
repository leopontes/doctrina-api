package br.com.doctrina.repository;

import org.springframework.stereotype.Repository;

import br.com.doctrina.entity.Topico;
import br.com.doctrina.spring.support.ICrudRepository;

@Repository
public interface TopicoRepository extends ICrudRepository<Topico>{

}
