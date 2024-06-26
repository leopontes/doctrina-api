package br.com.doctrina.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginDTO implements Serializable{

	private static final long serialVersionUID = 1331863468382232555L;
	
	private String nome;
	private String username;
	private String password;
}
