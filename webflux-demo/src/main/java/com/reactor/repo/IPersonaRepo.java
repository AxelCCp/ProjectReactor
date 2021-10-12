package com.reactor.repo;

import com.reactor.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonaRepo {
	
	Mono<Persona>registrar(Persona per);
	Mono<Persona>modificar(Persona per);
	Flux<Persona>listar();
	Mono<Persona>listarPorId();
	Mono<Void> eliminar(Integer id);	

}
