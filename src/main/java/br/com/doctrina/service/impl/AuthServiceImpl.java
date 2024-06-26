package br.com.doctrina.service.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import br.com.doctrina.dto.LoginDTO;
import br.com.doctrina.entity.Perfil;
import br.com.doctrina.entity.Usuario;
import br.com.doctrina.repository.PerfilRepository;
import br.com.doctrina.repository.UsuarioRepository;
import br.com.doctrina.service.AuthService;
import br.com.doctrina.spring.exception.BusinessException;
import lombok.extern.java.Log;

@Log
@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
    private JwtEncoder jwtEncoder;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PerfilRepository perfilRepository;
    
	@Override
	public String generateToken(Authentication authentication) {
		Instant now = Instant.now();

        String scope = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(10, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}

	@Override
	public void registrarAluno(LoginDTO login) {
		registrar(login.getUsername(), login.getPassword(), login.getNome(), "ALUNO");
	}

	@Override
	public void registrarEducador(LoginDTO login) {
		registrar(login.getUsername(), login.getPassword(), login.getNome(), "EDUCADOR");
	}
	
	private void registrar(String username, String password, String nome, String codigoPerfil) {
	
		if(usuarioRepository.findByLogin(username).isPresent()) {
			throw new BusinessException("Username already exists");
		}
		
		Optional<Perfil> perfil = perfilRepository.findByCodigo(codigoPerfil);
		
		if(perfil.isEmpty()) {
			throw new BusinessException("Perfil inválido.");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(username);
		usuario.setLogin(username);
		usuario.setPerfil(perfil.get());
		usuario.setSenha(passwordEncoder.encode(password));
		usuario.setAtivo(Boolean.TRUE);
		usuario.setValidado(Boolean.FALSE);
		
		usuarioRepository.save(usuario);
		
	}
}
