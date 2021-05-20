package com.israelgda.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.israelgda.webservice.entities.Categoria;

public interface RepositoryCategorias extends JpaRepository<Categoria, Long>{

}
