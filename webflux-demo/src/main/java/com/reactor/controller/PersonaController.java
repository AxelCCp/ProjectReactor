package com.reactor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactor.model.Persona;
import com.reactor.repo.IPersonaRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@GetMapping
	public Flux<Persona> listar(){
		return personaRepo.listar();
	}
	
	
	@GetMapping("/{id}")
	public Flux<Persona> listarPorId(@PathVariable(value="id") Integer id){
		return personaRepo.listarPorId(id);
	}
	
	
	@PostMapping
	public Mono<Persona> registrar(@RequestBody Persona per){
		return personaRepo.registrar(per);
	}
	
	@PutMapping
	public Mono<Persona> modificar(@RequestBody Persona per){
		return personaRepo.modificar	(per);
	}

	
	
	@Autowired
	private IPersonaRepo personaRepo; 
	
	private static final Logger log = LoggerFactory.getLogger(PersonaController.class);
}
