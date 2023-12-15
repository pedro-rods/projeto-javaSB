package com.zeush.admin.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private String cpfCNPJ, razao_social, nome_fantasia, endereco, cep, cidade, estado, pais, tipoCadastro, tipoEmpresa;

	@Getter @Setter
	private Integer quantidade; 
	
	@Getter	@OneToMany(mappedBy = "empresa") @JsonIgnore
	private List<Paciente> pacientes = new ArrayList<>();
	
	@Getter @Setter
	private Empresa empresaPai; 

	@Getter	@ManyToMany @JsonIgnore
	@JoinTable(name = "tb_empresa_profissional", joinColumns = @JoinColumn(name = "id_empresa"), inverseJoinColumns = @JoinColumn(name = "id_profissional"))
	private List<Profissional> profissionais = new ArrayList<>();


	public Empresa(Long id_empresa, String cpfCNPJ, String razao_social, String nome_fantasia, String endereco,
			String cep, String cidade, String estado, String pais, Integer quantidade, String tipoCadastro,
			String tipoEmpresa) {
		super();
		this.id_empresa = id_empresa;
		this.cpfCNPJ = cpfCNPJ;
		this.razao_social = razao_social;
		this.nome_fantasia = nome_fantasia;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.quantidade = quantidade;
		this.tipoCadastro = tipoCadastro;
		this.tipoEmpresa = tipoEmpresa;
	}
	

}
