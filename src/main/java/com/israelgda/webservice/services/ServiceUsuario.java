package com.israelgda.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.israelgda.webservice.entities.Usuario;
import com.israelgda.webservice.repositories.RepositoryUsuarios;
import com.israelgda.webservice.services.exceptions.DatabaseException;
import com.israelgda.webservice.services.exceptions.ResourceNotFoundException;

/*Anotação de Service serve para registrar como componente do Springboot, pelo uso do Anotation
 *@Autowired para injecao de dependencia
 */

@Service
public class ServiceUsuario {
	
	@Autowired
	private RepositoryUsuarios repository;
	
	//Métodos
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Insert 
	public Usuario insert(Usuario user) {
		return repository.save(user);
	}
	
	//Delete
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//Update
	public Usuario update(Long id, Usuario user) {
		Usuario entity = repository.getOne(id);
		updateData(entity, user);
		return repository.save(entity);
	}

	private void updateData(Usuario entity, Usuario user) {
		entity.setNome(user.getNome());
		entity.setEmail(user.getEmail());
		entity.setTelefone(user.getTelefone());
	}
}
