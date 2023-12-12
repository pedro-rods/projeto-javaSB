package com.zeush.admin.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_profissional")
public class Profissional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id_profissional;
	@Getter
	@Setter
	private String nome, email, senha, telefone, especialidade, tipo_credencial, credencial, imagemAssinatura, perfil;
	@Getter
	@Setter
	private Boolean laudo;
}
