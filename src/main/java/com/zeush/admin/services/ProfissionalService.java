package com.zeush.admin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.zeush.admin.entities.Profissional;
import com.zeush.admin.repositories.ProfissionalRepository;
import com.zeush.admin.services.exceptions.DatabaseException;
import com.zeush.admin.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repository;

	public List<Profissional> buscarTodos() {
		return repository.findAll();
	}

	public Profissional buscarPorId(Long id) {
		Optional<Profissional> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Profissional cadastrar(Profissional obj) {
		return repository.save(obj);
	}

	public void deletarProfissional(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Profissional alterarUsuario(Long id, Profissional obj) {
		try {
			Profissional entity = repository.getReferenceById(id);
			alterarData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void alterarData(Profissional entity, Profissional obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setSenha(obj.getSenha());
		entity.setTelefone(obj.getTelefone());
		entity.setEspecialidade(obj.getCredencial());
		entity.setTipo_credencial(obj.getTipo_credencial());
		entity.setCredencial(obj.getCredencial());
		entity.setImagemAssinatura(obj.getImagemAssinatura());
		entity.setPerfil(obj.getPerfil());
		entity.setLaudo(obj.getLaudo());

		repository.save(entity);

	}
}
