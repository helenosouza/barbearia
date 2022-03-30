package com.projeto.barbearia.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.barbearia.domain.Barbeiro;
//import com.projeto.barbearia.domain.Pessoa;
import com.projeto.barbearia.domain.DTO.BarbeiroDTO;
import com.projeto.barbearia.repositories.BarbeiroRepository;
import com.projeto.barbearia.services.exceptions.DataIntegrityViolationException;
//import com.projeto.barbearia.repositories.PessoaRepository;
//import com.projeto.barbearia.services.exceptions.DataIntegrityViolationException;
import com.projeto.barbearia.services.exceptions.ObjectnotFoundException;

@Service
public class BarbeiroService {
	
	@Autowired
	private BarbeiroRepository barbeiroRepository;
	
	//@Autowired
	//private PessoaRepository pessoaRepository;
	
	public Barbeiro findById(Integer id) {
		Optional<Barbeiro> obj = barbeiroRepository.findById(id);
		return obj.orElseThrow(() ->new ObjectnotFoundException("Objeto não encontrado. Id="+id));
	}

	public List<Barbeiro> findAll() {
		return barbeiroRepository.findAll();
	}

	public Barbeiro create(BarbeiroDTO objDTO) {
		objDTO.setId(null);
		//validaPorCPFETelefone(objDTO);
		Barbeiro newObj = new Barbeiro(objDTO);
		return barbeiroRepository.save(newObj);
	}

	public Barbeiro update(Integer id, @Valid BarbeiroDTO objDTO) {
		objDTO.setId(id);
		Barbeiro oldObj = findById(id);
		oldObj = new Barbeiro(objDTO);
		return barbeiroRepository.save(oldObj);
	}

	public void delete(Integer id) {
		Barbeiro obj = findById(id);
		if (obj.getAgendamentos().size() > 0) {
			throw new DataIntegrityViolationException("Barbeiro não pode ser deletado pois possui atendimentos");
		}
		
		barbeiroRepository.deleteById(id);
		
	}

	/*
	private void validaPorCPFETelefone(BarbeiroDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já Cadastrado!");
		}
		
	}*/
}
