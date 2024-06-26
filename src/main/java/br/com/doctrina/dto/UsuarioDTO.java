package br.com.doctrina.dto;

import lombok.Data;

@Data
public class UsuarioDTO implements DTO{

	private static final long serialVersionUID = -5216100341979236032L;

	private Long id;
	private PerfilDTO perfil;
	private String login; 
	private String email;
	private String nome;
	private String senha;
	private Boolean ativo;
	private Boolean validado;
}
