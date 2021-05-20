package com.israelgda.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.webservice.entities.Produto;
import com.israelgda.webservice.repositories.RepositoryProdutos;

/*Anotação de Service serve para registrar como componente do Springboot, pelo uso do Anotation
 *@Autowired para injecao de dependencia
 */

@Service
public class ServiceProduto {
	
	@Autowired
	private RepositoryProdutos repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}
	
}
