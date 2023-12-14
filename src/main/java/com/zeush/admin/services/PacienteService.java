package com.zeush.admin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeush.admin.entities.Paciente;
import com.zeush.admin.repositories.PacienteRepository;
import com.zeush.admin.services.exceptions.ResourceNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository; 
	
	public List<Paciente> buscarTodos() {
		return repository.findAll(); 
	}
	
	public Paciente buscarPorId(Long id) {
		Optional<Paciente> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id)); 
	}
	
	public Paciente cadastrarUsuario (Paciente obj) {
		return repository.save(obj);
	}
	
	public void deletarPaciente(Long id) {
		repository.deleteById(id);
	}
	
	public Paciente alterarUsuario(Long id, Paciente obj) {
		Paciente entity = repository.getReferenceById(id);
		alterarData(entity, obj); 
		return repository.save(entity); 
	}

	private void alterarData(Paciente entity, Paciente obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setSexo(obj.getSexo());
		entity.setTelefone(obj.getTelefone());
		entity.setDataNasc(obj.getDataNasc());
		entity.setEmpresa(obj.getEmpresa());
		
		repository.save(entity); 		
	}
	
}
