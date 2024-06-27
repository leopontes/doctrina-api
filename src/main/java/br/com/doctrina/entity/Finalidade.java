package br.com.doctrina.entity;

import java.util.Date;

import br.com.doctrina.spring.support.IEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "finalidade")
public class Finalidade implements IEntity{

	private static final long serialVersionUID = -2707018713914460609L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fina_cd_id", insertable = false, updatable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "grup_cd_id")
	private Grupo grupo;
	
	@Column(name = "fina_tx_nome")
	private String nome;
	
	@Column(name = "fina_dt_inicio")
	private Date inicio;
	
	@Column(name = "fina_dt_fim")
	private Date fim;
}
