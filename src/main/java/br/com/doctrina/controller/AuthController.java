package br.com.doctrina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doctrina.dto.AuthDTO;
import br.com.doctrina.dto.LoginDTO;
import br.com.doctrina.service.AuthService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO userLogin) throws IllegalAccessException {
        
		try {
			
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			//AuthUser userDetails = (AuthUser) authentication.getPrincipal();
			
			log.info("Token requested for user :{}" + authentication.getAuthorities());
			String token = authService.generateToken(authentication);
			
			return ResponseEntity.ok(
					AuthDTO.builder()
					.token(token)
					.message("User logged in successfully")
					.build()
					);
			
		} catch (Exception e) {
			log.error("Erro ao autenticar o usuario", e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					             .body(AuthDTO.builder()
					            		 	  .message("Login failed")
					            		 	  .build()
					              );
		}
		
    }
	
	@PostMapping("/aluno")
    public ResponseEntity<String> registerAluno(@RequestBody LoginDTO registerRequest) {
		authService.registrarAluno(registerRequest);
        return ResponseEntity.ok("User registered successfully");
    }
	
	@PostMapping("/educador")
    public ResponseEntity<String> registerEducador(@RequestBody LoginDTO registerRequest) {
		authService.registrarEducador(registerRequest);
        return ResponseEntity.ok("User registered successfully");
    }
}
