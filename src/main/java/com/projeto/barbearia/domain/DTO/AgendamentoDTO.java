package com.projeto.barbearia.domain.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.barbearia.domain.Agendamento;
import com.projeto.barbearia.enums.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AgendamentoDTO {

	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAgendamento;
	private Status status;
	private String observacoes;
	private Integer barbeiro;
	private Integer cliente;
	private String nomeBarbeiro;
	private String nomeCliente;
	

	public AgendamentoDTO(Agendamento obj) {
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataAgendamento = obj.getDataAgendamento();
		this.status = obj.getStatus();
		this.observacoes = obj.getObservacoes();
		this.barbeiro = obj.getBarbeiro().getId();
		this.cliente = obj.getCliente().getId();
		this.nomeBarbeiro = obj.getBarbeiro().getNome();
		this.nomeCliente = obj.getCliente().getNome();
	}
	
	

	
	

}
