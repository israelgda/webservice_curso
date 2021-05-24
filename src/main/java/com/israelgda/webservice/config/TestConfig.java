package com.israelgda.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.israelgda.webservice.entities.Categoria;
import com.israelgda.webservice.entities.Pedido;
import com.israelgda.webservice.entities.Produto;
import com.israelgda.webservice.entities.Usuario;
import com.israelgda.webservice.entities.enums.StatusPedido;
import com.israelgda.webservice.repositories.RepositoryCategorias;
import com.israelgda.webservice.repositories.RepositoryPedidos;
import com.israelgda.webservice.repositories.RepositoryProdutos;
import com.israelgda.webservice.repositories.RepositoryUsuarios;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private RepositoryUsuarios repositoryUsuario;
	
	@Autowired
	private RepositoryPedidos repositoryPedido;
	
	@Autowired
	private RepositoryCategorias repositoryCategoria;
	
	@Autowired
	private RepositoryProdutos repositoryProduto;

	@Override
	public void run(String... args) throws Exception {
		
		//Instanciação de produtos
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		//Instanciação de categorias
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers"); 
		
		repositoryCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
		repositoryProduto.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		//Assossiação na JoinTable de Produtos x Categorias
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		repositoryProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		//Instanciação seed dos usuários
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Instanciação seed dos pedidos
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAID, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.WAITING_PAYMENT, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.WAITING_PAYMENT, u1);
		
		repositoryUsuario.saveAll(Arrays.asList(u1, u2));
		repositoryPedido.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
}
