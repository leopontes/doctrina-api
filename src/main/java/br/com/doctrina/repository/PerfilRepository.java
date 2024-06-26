package br.com.doctrina.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.doctrina.entity.Perfil;
import br.com.doctrina.spring.support.ICrudRepository;

@Repository
public interface PerfilRepository extends ICrudRepository<Perfil>{

	Optional<Perfil> findByCodigo(String codigoPerfil);

}
