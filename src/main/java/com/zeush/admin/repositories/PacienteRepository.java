package com.zeush.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeush.admin.entities.Paciente;

public interface PacienteRepository  extends JpaRepository<Paciente, Long>{

}
