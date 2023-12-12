package com.zeush.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeush.admin.entities.Empresa;
import com.zeush.admin.services.EmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService service; 
	
	@GetMapping
	public ResponseEntity<List<Empresa>> buscarTodos() {
		List<Empresa> list = service.buscarTodos();
		return ResponseEntity.ok().body(list); 
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {
		Empresa obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj); 
	}
}
