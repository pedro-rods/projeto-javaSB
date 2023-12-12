package com.zeush.admin.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Profissional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private  Long id_profissional;
	@Getter
	@Setter
	private String nome, email, senha, telefone, especialidade, tipo_credencial, credencial, imagemAssinatura, perfil;
	@Getter
	@Setter
	private Boolean laudo;
}
