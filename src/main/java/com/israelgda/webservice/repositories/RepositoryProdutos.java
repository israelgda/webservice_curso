package com.israelgda.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.israelgda.webservice.entities.Produto;

public interface RepositoryProdutos extends JpaRepository<Produto, Long>{

}
