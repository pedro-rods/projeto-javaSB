package com.zeush.admin.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeush.admin.entities.Profissional;

@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalController {

	@GetMapping
	public ResponseEntity<Profissional> buscarTodos() {
		Profissional pr = new Profissional(1L, "profssional", "prof@gmail.com", "senhaExemplo",
				"(61)1111111111", "Cardiologista", "CRM", "1212121", "pathAssinatura", "perfil:Profissional", true);
				return ResponseEntity.ok().body(pr); 
	}
}
