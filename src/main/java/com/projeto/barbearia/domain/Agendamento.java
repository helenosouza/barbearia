package com.projeto.barbearia.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.barbearia.enums.Status;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"dataAbertura","dataAgendamento","status","observacoes","barbeiro","cliente"})
public class Agendamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAgendamento;
	private Status status;
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(name = "barbeiro_id")
	private Barbeiro barbeiro;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Agendamento(Integer id, Status status, String observacoes, Barbeiro barbeiro, Cliente cliente) {
		super();
		this.id = id;
		this.status = status;
		this.observacoes = observacoes;
		this.barbeiro = barbeiro;
		this.cliente = cliente;
	}
	
	
	
}
