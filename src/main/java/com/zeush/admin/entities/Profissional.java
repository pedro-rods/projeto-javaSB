package com.zeush.admin.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "tb_profissional")
public class Profissional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter	@Setter	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id_profissional;
	
	@Getter	@Setter
	private String nome, email, senha, telefone, especialidade, tipo_credencial, credencial, imagemAssinatura, perfil;
	
	@Getter	@Setter
	private Boolean laudo;
	
	@Getter	@ManyToMany(mappedBy = "profissionais")
	private Set<Empresa> empresas = new HashSet<>();
	
	public Profissional(Long id_profissional, String nome, String email, String senha, String telefone,
			String especialidade, String tipo_credencial, String credencial, String imagemAssinatura, String perfil,
			Boolean laudo) {
		super();
		this.id_profissional = id_profissional;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.especialidade = especialidade;
		this.tipo_credencial = tipo_credencial;
		this.credencial = credencial;
		this.imagemAssinatura = imagemAssinatura;
		this.perfil = perfil;
		this.laudo = laudo;
	}
	
}
