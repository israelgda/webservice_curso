package com.israelgda.webservice.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.israelgda.webservice.entities.enums.StatusPedido;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer statusPedido;
	
	//Associacao
	/*
	 * As anotações abaixo dizem que a associação é de muitos para um, e o JoinColumn faz a 
	 * associação do nome da chave estrageira definida no parametro "name"
	 */
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Usuario client;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	//Construtores
	public Pedido(){
	}

	public Pedido(Long id, Instant moment, StatusPedido statusPedido, Usuario client) {
		super();
		this.id = id;
		this.moment = moment;
		setStatusPedido(statusPedido);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	

	public StatusPedido getStatusPedido() {
		return StatusPedido.valueOf(statusPedido);
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		if(statusPedido != null) {
			this.statusPedido = statusPedido.getCodigo();
		}
	}

	public Usuario getClient() {
		return client;
	}

	public void setClient(Usuario client) {
		this.client = client;
	}
	
	public Set<ItemPedido> getItens(){
		return itens;
	}

	//HashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
