
package com.projeto.barbearia.domain.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.barbearia.domain.Barbeiro;
import com.projeto.barbearia.enums.Perfil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarbeiroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer id;
	@NotNull(message = "O campo NOME é obrigatorio!")
	protected String nome;
	@NotNull(message = "O campo CPF é obrigatorio!")
	protected String cpf;
	@NotNull(message = "O campo Telefone é obrigatorio!")
	protected String telefone;
	@NotNull(message = "O campo SENHA é obrigatorio!")
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

	public BarbeiroDTO() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public BarbeiroDTO(Barbeiro obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		addPerfil(Perfil.CLIENTE);
	}
	
	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil){
		this.perfis.add(perfil.getCodigo());
	}

}
