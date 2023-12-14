package com.zeush.admin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeush.admin.entities.Empresa;
import com.zeush.admin.repositories.EmpresaRepository;
import com.zeush.admin.services.exceptions.ResourceNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository; 
	
	public List<Empresa> buscarTodos() {
		return repository.findAll(); 
	}
	
	public Empresa buscarPorId(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id)); 
	}
	
	public Empresa cadastrarEmpresa (Empresa obj) {
		return repository.save(obj);
	}
	public void deletarEmpresa(Long id) {
		repository.deleteById(id);
	}
	
	public Empresa alterarEmpresa(Long id, Empresa obj) {
		Empresa entity = repository.getReferenceById(id);
		alterarData(entity, obj); 
		return repository.save(entity); 
	}

	private void alterarData(Empresa entity, Empresa obj) {
		entity.setCpfCNPJ(obj.getCpfCNPJ());
		entity.setNome_fantasia(obj.getNome_fantasia());
		entity.setRazao_social(obj.getRazao_social());
		
		repository.save(entity); 		
	}
}
