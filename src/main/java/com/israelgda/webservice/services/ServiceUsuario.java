package com.israelgda.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.webservice.entities.Usuario;
import com.israelgda.webservice.repositories.RepositoryUsuarios;

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
		return obj.get();
	}
	
	//Insert 
	public Usuario insert(Usuario user) {
		return repository.save(user);
	}
	
	//Delete
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
