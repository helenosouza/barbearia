package com.projeto.barbearia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
	
	SOLICITADO(0,"ROLE_SOLICITADO"), AGENDADO(1,"ROLE_SOLICITADO"), CANCELADO(2, "ROLE_CANCELADO");
	
	private Integer codigo;
	private String descricao;
	
	public static Status toEnum(Integer	cod) {
		if (cod == null) {
			return null; 
		}
		
		for(Status x : Status.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil Inválido");
	}
}
