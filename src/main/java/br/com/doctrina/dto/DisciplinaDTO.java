package br.com.doctrina.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class DisciplinaDTO implements DTO{

	private static final long serialVersionUID = 440088798326076758L;

	private Long id;
	private String nome;
	private String codigo;
	private Collection<TopicoDTO> topicos; 
}
