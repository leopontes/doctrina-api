package br.com.doctrina.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class TopicoDTO implements DTO{

	private static final long serialVersionUID = 1497924976123623614L;

	private Long id;
	private String nome;
	private String conteudo;
	private String link;
	private Collection<ComplementoDTO> complemento;
}
