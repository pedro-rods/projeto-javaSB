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
@Table(name = "tb_empresa")
public class Empresa  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Setter
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empresa;
	
	@Getter
	@Setter
	private String cnpj, razao_social, nome_fantasia; 
	
}
