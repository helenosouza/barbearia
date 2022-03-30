package com.projeto.barbearia.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.barbearia.domain.Agendamento;
import com.projeto.barbearia.domain.Barbeiro;
import com.projeto.barbearia.domain.Cliente;
import com.projeto.barbearia.enums.Perfil;
import com.projeto.barbearia.enums.Status;
import com.projeto.barbearia.repositories.AgendamentoRepository;
import com.projeto.barbearia.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public void instanciaDB() {
		
		Barbeiro bar1 = new Barbeiro(null, "Heleno Silva", "550.482.150-95", "99 90000-0001", "123");
		bar1.addPerfil(Perfil.ADMIN);
		Barbeiro bar2 = new Barbeiro(null, "Mardoqueu Sousa", "903.347.070-56", "99 90000-0002","123");
		Barbeiro bar3 = new Barbeiro(null, "Elielson Santos", "271.068.470-54", "99 90000-0003","123");
		Barbeiro bar4 = new Barbeiro(null, "Silva dos Santos", "162.720.120-39", "99 90000-0004", "123");
		Barbeiro bar5 = new Barbeiro(null, "Anderson Mende", "778.556.170-27", "99 90000-0005", "123");

		Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "99 90000-0006","123");
		Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "99 90000-0007", "123");
		Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "99 90000-0008", "123");
		Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "99 90000-009","123");
		Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "99 90000-0000", "123");

		Agendamento c1 = new Agendamento(null, Status.AGENDADO, "Teste Agendamento 1", bar1, cli1);
		Agendamento c2 = new Agendamento(null, Status.SOLICITADO, "Teste Agendamento 2", bar1, cli2);
		Agendamento c3 = new Agendamento(null, Status.CANCELADO, "Teste Agendamento 3", bar2, cli3);
		Agendamento c4 = new Agendamento(null, Status.AGENDADO, "Teste Agendamento 4", bar3, cli3);
		Agendamento c5 = new Agendamento(null, Status.SOLICITADO, "Teste Agendamento 5", bar2, cli1);
		Agendamento c6 = new Agendamento(null, Status.CANCELADO, "Teste Agendamento 6", bar1, cli5);

		pessoaRepository.saveAll(Arrays.asList(bar1, bar2, bar3, bar4, bar5, cli1, cli2, cli3, cli4, cli5));
		agendamentoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

	}

}
