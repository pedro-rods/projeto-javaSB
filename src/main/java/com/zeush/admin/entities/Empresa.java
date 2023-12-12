package com.zeush.admin.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Empresa  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Setter
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Long id_empresa;

	@NonNull
	@Getter
	@Setter
	private String cpfCNPJ, razao_social, nome_fantasia; 
	
	
	@Getter
	@OneToMany(mappedBy = "empresa")
	@JsonIgnore
	private  List<Paciente> pacientes = new ArrayList<>();


	public Empresa(Long id_empresa, String cpfCNPJ, String razao_social, String nome_fantasia) {
		super();
		this.id_empresa = id_empresa;
		this.cpfCNPJ = cpfCNPJ;
		this.razao_social = razao_social;
		this.nome_fantasia = nome_fantasia;
	} 
	
	
	
}
