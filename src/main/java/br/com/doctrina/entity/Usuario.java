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

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario implements IEntity{

	private static final long serialVersionUID = -6766657639829474463L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usua_cd_id", insertable = false, updatable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "perf_cd_id")
	private Perfil perfil;
	
	@Column(name = "usua_tx_login")
	private String login; 
	
	@Column(name = "usua_tx_email")
	private String email;
	
	@Column(name = "usua_tx_nome")
	private String nome;
	
	@Column(name = "usua_tx_senha")
	private String senha;
	
	@Column(name = "usua_in_ativo")
	private Boolean ativo;
	
	@Column(name = "usua_in_validado")
	private Boolean validado;
}
