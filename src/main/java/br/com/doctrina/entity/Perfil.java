package br.com.doctrina.entity;

import br.com.doctrina.spring.support.IEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "perfil")
@Getter
@Setter
public class Perfil implements IEntity{

	private static final long serialVersionUID = 2563460447843038865L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "perf_cd_id", insertable = false, updatable = false)
	private Long id;
	
	@Column(name = "perf_tx_nome")
	private String nome; 
	
	@Column(name = "perf_tx_codigo")
	private String codigo;
	
	@Column(name = "perf_tx_descricao")
	private String descricao;
	
	@Column(name = "perf_in_ativo")
	private Boolean ativo;
}
