package com.zeush.admin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeush.admin.entities.Paciente;
import com.zeush.admin.repositories.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository; 
	
	public List<Paciente> buscarTodos() {
		return repository.findAll(); 
	}
	
	public Paciente buscarPorId(Long id) {
		Optional<Paciente> obj = repository.findById(id);
		return obj.get(); 
	}
	
	public Paciente cadastrar (Paciente obj) {
		return repository.save(obj);
	}
	
	
}
