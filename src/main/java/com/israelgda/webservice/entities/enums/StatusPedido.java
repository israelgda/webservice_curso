package com.israelgda.webservice.entities.enums;

public enum StatusPedido {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusPedido valueOf(int codigo) {
		for(StatusPedido sp: StatusPedido.values()) {
			if(sp.getCodigo() == codigo) {
				return sp;
			}
		}
		throw new IllegalArgumentException("Este código de status é inválido!");
	}
}
