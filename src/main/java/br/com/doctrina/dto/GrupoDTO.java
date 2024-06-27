package br.com.doctrina.dto;

import java.util.Collection;
import java.util.Date;

import lombok.Data;

@Data
public class GrupoDTO implements DTO{

	private static final long serialVersionUID = 775570255848750683L;

	private Long id;
	private String nome;
	private Date dataCriacao;
	private Collection<FinalidadeDTO> finalidades;
}
