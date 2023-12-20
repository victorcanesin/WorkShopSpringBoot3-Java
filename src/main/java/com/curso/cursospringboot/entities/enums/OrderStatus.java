package com.curso.cursospringboot.entities.enums;

public enum OrderStatus {
	
	AGUARDANDO_PAGAMENTO(1 , "Aguardando pagamento"),
	PAGO(2 , "Pago"),
	ENVIADO(3, "Enviado"),
	ENTREGUE(4 , "Entregue"),
	ENCERRADO(5 , "Encerrado"),
	CANCELADO(6 , "Cancelado");
	
	private Integer id;
	private String descricao;
	
	OrderStatus(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static OrderStatus valueOf(int code) {
		
		for (OrderStatus value : OrderStatus.values()) {
			if(value.getId() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código de order status inválido!");
	}

}