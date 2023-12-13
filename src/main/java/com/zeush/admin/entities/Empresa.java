package com.zeush.admin.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Setter	@Getter	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empresa;

	@Getter	@Setter
	private String cpfCNPJ, razao_social, nome_fantasia;

	@Getter	@OneToMany(mappedBy = "empresa") @JsonIgnore
	private List<Paciente> pacientes = new ArrayList<>();

	@Getter	@ManyToMany @JsonIgnore
	@JoinTable(name = "tb_empresa_profissional", joinColumns = @JoinColumn(name = "id_empresa"), inverseJoinColumns = @JoinColumn(name = "id_profissional"))
	private Set<Profissional> profissionais = new HashSet<>();

	public Empresa(Long id_empresa, String cpfCNPJ, String razao_social, String nome_fantasia) {
		super();
		this.id_empresa = id_empresa;
		this.cpfCNPJ = cpfCNPJ;
		this.razao_social = razao_social;
		this.nome_fantasia = nome_fantasia;
	}

}
