package com.projeto.barbearia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.barbearia.domain.Barbeiro;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, Integer>{

}
