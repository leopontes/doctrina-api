package br.com.doctrina.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.doctrina.entity.Usuario;
import br.com.doctrina.spring.support.ICrudRepository;

@Repository
public interface UsuarioRepository extends ICrudRepository<Usuario>{

	Optional<Usuario> findByLogin(String username);

}
