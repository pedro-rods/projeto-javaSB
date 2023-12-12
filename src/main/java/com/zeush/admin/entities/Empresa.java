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
public class Empresa  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String cnpj, razao_social, nome_fantasia; 
	
}
