package com.projeto.barbearia.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.barbearia.domain.Barbeiro;
import com.projeto.barbearia.domain.DTO.BarbeiroDTO;
import com.projeto.barbearia.services.BarbeiroService;

@RestController
@RequestMapping(value = "/barbeiros")
public class BarbeiroResource {
	
	@Autowired
	private BarbeiroService barbeiroServices;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BarbeiroDTO> findById(@PathVariable Integer id){
		Barbeiro obj = barbeiroServices.findById(id);
		return ResponseEntity.ok().body(new BarbeiroDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<BarbeiroDTO>> findAll(){
		List<Barbeiro> list = barbeiroServices.findAll();
		List<BarbeiroDTO> listDTO = list.stream().map(obj -> new BarbeiroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<BarbeiroDTO> create(@Valid @RequestBody BarbeiroDTO objDTO){
		Barbeiro newObj = barbeiroServices.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<BarbeiroDTO> update(@PathVariable Integer id, @Valid @RequestBody BarbeiroDTO objDTO){
		Barbeiro obj = barbeiroServices.update(id, objDTO);
		return ResponseEntity.ok().body(new BarbeiroDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<BarbeiroDTO> delete(@PathVariable Integer id){
		barbeiroServices.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}









