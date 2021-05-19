package com.israelgda.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.webservice.entities.Pedido;
import com.israelgda.webservice.entities.Usuario;
import com.israelgda.webservice.repositories.RepositoryPedidos;

/*Anotação de Service serve para registrar como componente do Springboot, pelo uso do Anotation
 *@Autowired para injecao de dependencia
 */

@Service
public class ServicePedido {
	
	@Autowired
	private RepositoryPedidos repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}
	
}
