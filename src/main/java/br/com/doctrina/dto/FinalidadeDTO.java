package br.com.doctrina.dto;

import java.util.Collection;
import java.util.Date;

import lombok.Data;

@Data
public class FinalidadeDTO implements DTO{

	private static final long serialVersionUID = -3560035716917119213L;
	
	private Long id;
	private String nome;
	private Date inicio;
	private Date fim;
	private Collection<DisciplinaDTO> disciplinas;
}
