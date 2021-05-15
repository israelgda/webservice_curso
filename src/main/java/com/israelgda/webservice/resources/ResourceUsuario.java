package com.israelgda.webservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.israelgda.webservice.entities.Usuario;

@RestController
@RequestMapping(value= "/usuarios")
public class ResourceUsuario {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(1L, "Israel", "israel@gmail.com", "123874657", "israel123");
		return ResponseEntity.ok().body(u);
	}
}
