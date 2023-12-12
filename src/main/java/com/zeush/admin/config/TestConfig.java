package com.zeush.admin.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zeush.admin.entities.Paciente;
import com.zeush.admin.repositories.PacienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Paciente p1 = new Paciente(null, "Tst1", "tst1@mail.com", "Masculino", "98078675", "10052003", 2);
		Paciente p2 = new Paciente(null, "Tst2", "tst2@mail.com", "Feminino", "333333333", "07072023", 2);
		
		pacienteRepository.saveAll(Arrays.asList(p1,p2)); 
	}
	
	
}
