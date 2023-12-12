package com.zeush.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeush.admin.entities.Paciente;
import com.zeush.admin.services.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService service; 
	
	@GetMapping
	public ResponseEntity<List<Paciente>> buscarTodos() {
		List<Paciente> list = service.buscarTodos();
		return ResponseEntity.ok().body(list); 
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
		Paciente obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj); 
	}
}
