package com.projeto.barbearia.repositories;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.barbearia.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	//Optional<Pessoa> findByCPF(String cpf);
	//Optional<Pessoa> findByTelefone(String telefone);

}
