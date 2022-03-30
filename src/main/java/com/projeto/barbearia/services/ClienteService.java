package com.projeto.barbearia.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.barbearia.domain.Cliente;
//import com.projeto.barbearia.domain.Pessoa;
import com.projeto.barbearia.domain.DTO.ClienteDTO;
import com.projeto.barbearia.repositories.ClienteRepository;
import com.projeto.barbearia.services.exceptions.DataIntegrityViolationException;
//import com.projeto.barbearia.repositories.PessoaRepository;
//import com.projeto.barbearia.services.exceptions.DataIntegrityViolationException;
import com.projeto.barbearia.services.exceptions.ObjectnotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository barbeiroRepository;
	
	//@Autowired
	//private PessoaRepository pessoaRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = barbeiroRepository.findById(id);
		return obj.orElseThrow(() ->new ObjectnotFoundException("Objeto não encontrado. Id="+id));
	}

	public List<Cliente> findAll() {
		return barbeiroRepository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		//validaPorCPFETelefone(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return barbeiroRepository.save(newObj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		oldObj = new Cliente(objDTO);
		return barbeiroRepository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		if (obj.getAgendamentos().size() > 0) {
			throw new DataIntegrityViolationException("Cliente não pode ser deletado pois possui atendimentos");
		}
		
		barbeiroRepository.deleteById(id);
		
	}

	/*
	private void validaPorCPFETelefone(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já Cadastrado!");
		}
		
	}*/
}
