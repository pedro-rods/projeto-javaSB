package com.zeush.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeush.admin.entities.Empresa;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long>{

}
