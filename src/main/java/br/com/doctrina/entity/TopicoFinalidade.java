package br.com.doctrina.entity;

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
@Table(name = "finalidade_topico")
public class TopicoFinalidade implements IEntity{

	private static final long serialVersionUID = -6067932786619530048L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fito_cd_id", insertable = false, updatable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "topi_cd_id")
	private Topico topico;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fina_cd_id")
	private Finalidade finalidade;
	
	@Column(name = "fito_tx_conteudo")
	private String conteudo;
	
	@Column(name = "fito_tx_link")
	private String link;
}
