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
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id_paciente;

	@Getter
	@Setter
	private String nome, email, sexo, telefone, dataNasc;

	@Getter
	@Setter
	private int empresa;
}
