package com.projeto.barbearia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.barbearia.domain.Agendamento;
import com.projeto.barbearia.repositories.AgendamentoRepository;
import com.projeto.barbearia.services.exceptions.ObjectnotFoundException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public Agendamento findById(Integer id) {
		Optional<Agendamento> obj = agendamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrafo! ID: "+id));
	}

	public List<Agendamento> finAll() {
		return agendamentoRepository.findAll();
	}
}
