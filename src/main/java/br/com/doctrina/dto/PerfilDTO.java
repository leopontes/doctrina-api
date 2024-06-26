package br.com.doctrina.dto;

import lombok.Data;

@Data
public class PerfilDTO implements DTO{

	private static final long serialVersionUID = 532609309296439578L;
	
	private Long id;
	private String nome; 
	private String codigo;
	private String descricao;
	private Boolean ativo;
}
