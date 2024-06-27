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
@Table(name = "finalidade_topico_complemento")
public class Complemento implements IEntity{

	private static final long serialVersionUID = -281180966285963834L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fitc_cd_id", insertable = false, updatable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fito_cd_id")
	private TopicoFinalidade topicoFinalidade;
	
	@Column(name = "fitc_tx_nome")
	private String nome;
	
	@Column(name = "fitc_tx_descricao")
	private String descricao;
	
	@Column(name = "fitc_tx_link")
	private String link;
	
	@Column(name = "fitc_dt_atualizacao")
	private Date dataAtualizacao;
}
