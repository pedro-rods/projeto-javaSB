package com.zeush.admin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeush.admin.entities.Profissional;
import com.zeush.admin.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repository; 
	
	public List<Profissional> buscarTodos() {
		return repository.findAll(); 
	}
	
	public Profissional buscarPorId(Long id) {
		Optional<Profissional> obj = repository.findById(id);
		return obj.get(); 
	}
	
	public Profissional cadastrar (Profissional obj) {
		return repository.save(obj);
	}
}
