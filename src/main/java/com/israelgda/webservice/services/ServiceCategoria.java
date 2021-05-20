package com.israelgda.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.webservice.entities.Categoria;
import com.israelgda.webservice.entities.Usuario;
import com.israelgda.webservice.repositories.RepositoryCategorias;

/*Anotação de Service serve para registrar como componente do Springboot, pelo uso do Anotation
 *@Autowired para injecao de dependencia
 */

@Service
public class ServiceCategoria {
	
	@Autowired
	private RepositoryCategorias repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.get();
	}
	
}
