package com.israelgda.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.israelgda.webservice.entities.Usuario;

public interface RepositoryUsuarios extends JpaRepository<Usuario, Long>{

}
