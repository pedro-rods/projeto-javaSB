package com.zeush.admin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.zeush.admin.entities.Empresa;
import com.zeush.admin.repositories.EmpresaRepository;
import com.zeush.admin.services.exceptions.DatabaseException;
import com.zeush.admin.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public List<Empresa> buscarTodos() {
		return repository.findAll();
	}

	public Empresa buscarPorId(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Empresa cadastrarEmpresa(Empresa obj) {
		return repository.save(obj);
	}

	public void deletarEmpresa(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Empresa alterarEmpresa(Long id, Empresa obj) {
		try {
			Empresa entity = repository.getReferenceById(id);
			alterarData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void alterarData(Empresa entity, Empresa obj) {
		entity.setCpfCNPJ(obj.getCpfCNPJ());
		entity.setNome_fantasia(obj.getNome_fantasia());
		entity.setRazao_social(obj.getRazao_social());
		entity.setCep(obj.getCep());
		entity.setCidade(obj.getCidade());
		entity.setEndereco(obj.getEndereco());
		entity.setQuantidade(obj.getQuantidade());
		entity.setPais(obj.getPais());
		entity.setTipoCadastro(obj.getTipoCadastro());
		entity.setTipoEmpresa(obj.getTipoEmpresa());
		entity.setEmpresaPai(obj.getEmpresaPai());

		repository.save(entity);
	}
}
