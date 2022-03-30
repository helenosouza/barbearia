package com.projeto.barbearia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Perfil {
	
	ADMIN(0,"ROLE_ADMIN"), CLIENTE(1,"ROLE_CLIENTE"), BARBEIRO(2, "ROLE_BARBEIRO");
	
	private Integer codigo;
	private String descricao;
	
	public static Perfil toEnum(Integer	cod) {
		if (cod == null) {
			return null; 
		}
		
		for(Perfil x : Perfil.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil Inválido");
	}
}
