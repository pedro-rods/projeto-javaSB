package com.zeush.admin.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Paciente> cadastrar(@RequestBody Paciente obj) {
		obj = service.cadastrarUsuario(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_paciente()).toUri();
		return ResponseEntity.created(uri).body(obj); 		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletarPaciente (@PathVariable Long id) {
		service.deletarPaciente(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Paciente> alterarUsuario (@PathVariable Long id, @RequestBody Paciente obj) {
		obj = service.alterarUsuario(id, obj);
		return ResponseEntity.ok().body(obj); 
	}
}
