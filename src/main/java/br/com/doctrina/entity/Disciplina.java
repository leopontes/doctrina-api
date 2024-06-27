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

@Getter
@Setter
@Entity
@Table(name = "disciplina")
public class Disciplina implements IEntity{

	private static final long serialVersionUID = -27315624815004418L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "disc_cd_id", insertable = false, updatable = false)
	private Long id;
	
	@Column(name = "disc_tx_nome")
	private String nome;
	
	@Column(name = "disc_tx_codigo")
	private String codigo;
}
