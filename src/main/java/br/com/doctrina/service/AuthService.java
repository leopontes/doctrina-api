package br.com.doctrina.service;

import org.springframework.security.core.Authentication;

import br.com.doctrina.dto.LoginDTO;

public interface AuthService {

	String generateToken(Authentication authentication);

	void registrarAluno(LoginDTO registerRequest);

	void registrarEducador(LoginDTO registerRequest);
}
