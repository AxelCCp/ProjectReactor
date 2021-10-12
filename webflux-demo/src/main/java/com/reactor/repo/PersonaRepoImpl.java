package com.reactor.repo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.reactor.controller.PersonaController;
import com.reactor.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonaRepoImpl implements IPersonaRepo {

	@Override
	public Mono<Persona> registrar(Persona per) {
		// TODO Auto-generated method stub
		log.info(per.toString());
		return Mono.just(per);
	}

	@Override
	public Mono<Persona> modificar(Persona per) {
		// TODO Auto-generated method stub
		log.info(per.toString());
		return Mono.just(per);
	}

	@Override
	public Flux<Persona> listar() {
		// TODO Auto-generated method stub
		List<Persona>personas = new ArrayList<>();
		personas.add(new Persona(1,"a"));
		personas.add(new Persona(2,"b"));
		personas.add(new Persona(3,"c"));
		return Flux.fromIterable(personas);
	}

	@Override
	public Mono<Persona> listarPorId() {
		// TODO Auto-generated method stub
		return Mono.just(new Persona(4,"d"));
	}

	@Override
	public Mono<Void> eliminar(Integer id) {
		// TODO Auto-generated method stub
		return Mono.empty();
	}
	
	private static final Logger log = LoggerFactory.getLogger(PersonaController.class);
}
