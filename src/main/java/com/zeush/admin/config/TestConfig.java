package com.zeush.admin.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zeush.admin.entities.Empresa;
import com.zeush.admin.entities.Paciente;
import com.zeush.admin.entities.Profissional;
import com.zeush.admin.repositories.EmpresaRepository;
import com.zeush.admin.repositories.PacienteRepository;
import com.zeush.admin.repositories.ProfissionalRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Instanciando as entidades Empresa, Paciente e Profissional
		 *  */
		Empresa e1 = new Empresa(null, "21111111111111", "Empresa11", "TstEmpresa11"); 
		Empresa e2 = new Empresa(null, "12222222222", "Empresa22", "TstEmpresa22"); 
		
		Paciente p1 = new Paciente(null, "Tst1", "tst1@mail.com", "Masculino", "98078675", "10052003", e1);
		Paciente p2 = new Paciente(null, "Tst2", "tst2@mail.com", "Feminino", "333333333", "07072023", e2);
		
		Profissional pr1 = new Profissional(null, "Teste1", "teste1@mail.com", "123456", "11111111111", "cardiologista", "crm", "123456", "caminho do arquivo", "profissional", true);
		Profissional pr2 = new Profissional(null, "Teste2", "teste2@mail.com", "123456", "222222222", "fisioterapeuta", "crm", "123456", "caminho do arquivo", "profissional", true);
		
		empresaRepository.saveAll(Arrays.asList(e1, e2));
		pacienteRepository.saveAll(Arrays.asList(p1,p2));  
		profissionalRepository.saveAll(Arrays.asList(pr1,pr2));
		
		// Vinculando um profissional às empresa
		e1.getProfissionais().add(pr1); 
		e2.getProfissionais().add(pr1); 
		empresaRepository.saveAll(Arrays.asList(e1,e2)); 
	}
	
	
}
