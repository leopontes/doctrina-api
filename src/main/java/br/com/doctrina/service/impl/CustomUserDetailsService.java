package br.com.doctrina.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.doctrina.entity.Usuario;
import br.com.doctrina.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UsuarioRepository userRepository;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = userRepository.findByLogin(username);
		
		if(usuario.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
		}
		
		return new User(
					usuario.get().getLogin(), 
					usuario.get().getSenha(), 
					Collections.singletonList(new SimpleGrantedAuthority(usuario.get().getPerfil().getCodigo()))
				);
	}

}
