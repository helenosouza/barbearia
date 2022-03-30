package com.projeto.barbearia.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.barbearia.domain.DTO.BarbeiroDTO;
import com.projeto.barbearia.enums.Perfil;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Barbeiro extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@JsonIgnore
	@OneToMany(mappedBy = "barbeiro")
	private List<Agendamento> agendamentos = new ArrayList<>();

	public Barbeiro() {
		super();
		addPerfil(Perfil.BARBEIRO);
	}

	public Barbeiro(Integer id, String nome, String cpf, String telefone, String senha) {
		super(id, nome, cpf, telefone, senha);
		addPerfil(Perfil.BARBEIRO);
	}
	
	public Barbeiro(BarbeiroDTO obj) {
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
	

}
