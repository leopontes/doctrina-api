package br.com.doctrina.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ComplementoDTO implements DTO{

	private static final long serialVersionUID = 4796853256501156581L;

	private Long id;
	private String nome;
	private String descricao;
	private String link;
	private Date dataAtualizacao;
}
