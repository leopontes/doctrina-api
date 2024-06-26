package br.com.doctrina.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthDTO implements Serializable{

	private static final long serialVersionUID = -8052071328817090763L;

	private String message;
	private String token;
}
