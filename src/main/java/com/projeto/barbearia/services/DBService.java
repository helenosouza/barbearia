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
import com.projeto.barbearia.repositories.BarbeiroRepository;
import com.projeto.barbearia.repositories.ClienteRepository;

@Service
public class DBService {
	
	@Autowired
	private BarbeiroRepository barbeiroRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public void instanciaDB() {
		
		Barbeiro bar1 = new Barbeiro(null, "heleno", "12345678", "12345678", "12345678");
		bar1.addPerfil(Perfil.BARBEIRO);
		
		Cliente cli1 = new Cliente(null, "kaury", "0000000000", "0000099999", "123");
		
		Agendamento ag1 = new Agendamento(null, Status.SOLICITADO, "nada da oaoao", bar1, cli1);
		
		barbeiroRepository.saveAll(Arrays.asList(bar1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		agendamentoRepository.saveAll(Arrays.asList(ag1));

	}

}
