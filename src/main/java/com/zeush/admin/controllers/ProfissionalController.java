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

import com.zeush.admin.entities.Profissional;
import com.zeush.admin.services.ProfissionalService;

@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalController {

	@Autowired
	private ProfissionalService service; 
	
	@GetMapping(value = "/buscar")
	public ResponseEntity<List<Profissional>> buscarTodos() {
		List<Profissional> list = service.buscarTodos();
		return ResponseEntity.ok().body(list); 
	}
	@GetMapping(value = "buscar/{id}")
	public ResponseEntity<Profissional> buscarPorId(@PathVariable Long id) {
		Profissional obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj); 
	}
	@PostMapping(value = "cadastrar")
	public ResponseEntity<Profissional> cadastrar(@RequestBody Profissional obj) {
		obj = service.cadastrar(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_profissional()).toUri();
		return ResponseEntity.created(uri).body(obj); 		
	}
	@DeleteMapping(value="deletar/{id}")
	public ResponseEntity<Void> deletarProfissional (@PathVariable Long id) {
		service.deletarProfissional(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "alterar/{id}")
	public ResponseEntity<Profissional> alterarUsuario (@PathVariable Long id, @RequestBody Profissional obj) {
		obj = service.alterarUsuario(id, obj);
		return ResponseEntity.ok().body(obj); 
	}
}
