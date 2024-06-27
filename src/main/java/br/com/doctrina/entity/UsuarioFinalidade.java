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
@Table(name = "usuario_finalidade")
public class UsuarioFinalidade implements IEntity{

	private static final long serialVersionUID = -3214446217716464000L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usfi_cd_id", insertable = false, updatable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fina_cd_id")
	private Finalidade finalidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usua_cd_id")
	private Usuario usuario;
	
	@Column(name = "usfi_in_adm")
	private Boolean administrador;
}
