package com.zeush.admin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeush.admin.entities.Empresa;
import com.zeush.admin.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository; 
	
	public List<Empresa> buscarTodos() {
		return repository.findAll(); 
	}
	
	public Empresa buscarPorId(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		return obj.get(); 
	}
	
	public Empresa cadastrar (Empresa obj) {
		return repository.save(obj);
	}
}
