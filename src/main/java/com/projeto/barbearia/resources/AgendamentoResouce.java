package com.projeto.barbearia.resources;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.barbearia.domain.Agendamento;
import com.projeto.barbearia.domain.DTO.AgendamentoDTO;
import com.projeto.barbearia.services.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResouce {
	
	@Autowired
	private AgendamentoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AgendamentoDTO> findById(@PathVariable Integer id){
		Agendamento obj = service.findById(id);
		return ResponseEntity.ok().body(new AgendamentoDTO(obj));
	}
	
	ResponseEntity<List<AgendamentoDTO>> findAll(){
		List<Agendamento> list = service.finAll();
		List<AgendamentoDTO> listDTO = list.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList()));
		return ResponseEntity.ok().body(listDTO);
	}
	
}
