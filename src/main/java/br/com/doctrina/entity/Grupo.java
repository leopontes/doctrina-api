package br.com.doctrina.entity;

import java.util.Date;

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
@Table(name = "grupo")
public class Grupo implements IEntity{

	private static final long serialVersionUID = -9004757052043870603L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grup_cd_id", insertable = false, updatable = false)
	private Long id;
	
	@Column(name = "grup_tx_nome")
	private String nome;
	
	@Column(name = "grup_dt_criacao")
	private Date dataCriacao;
}
