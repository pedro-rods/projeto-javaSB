package com.zeush.admin.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeush.admin.entities.Paciente;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

	@GetMapping
	public ResponseEntity<Paciente> buscarTodos() {
		Paciente p = new Paciente(1L, "Pedro", "Pedro@gmail.com", "masc", "98078675", "07052003", 1);
		return ResponseEntity.ok().body(p); 
	}
}
