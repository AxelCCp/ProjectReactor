package com.reactor.filtrado;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactor.model.Persona;

import reactor.core.publisher.Flux;

public class Filtrado {
	
	//CON EL FILTRO SE VERIFICA QUE ELEMENTOS TIENEN UNA EDAD MAYOR A 6
	public void filter() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"aaaaa",5));
		personas.add(new Persona(2,"bbbbb",6));
		personas.add(new Persona(3,"ccccc",7));
		personas.add(new Persona(4,"ddddd",8));
		
		Flux.fromIterable(personas)
		.filter(p -> p.getEdad() >6)
		.subscribe(p -> log.info(p.toString()));
	}
	
	public void distinc() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"aaaaa",5));
		personas.add(new Persona(1,"bbbbb",6));
		personas.add(new Persona(3,"ccccc",7));
		personas.add(new Persona(4,"ddddd",8));
		
		Flux.fromIterable(personas)
		.distinct()
		.subscribe(p -> log.info(p.toString()));
	}
	
	//EL DISTINC FUNCIONANDO CON UNA LISTA DE DATOS PROMITIVOS
	public void distinc2() {
		Flux.fromIterable(List.of(1,1,2,3,4,5,6,7))
		.distinct()
		.subscribe(n -> log.info(n.toString()));
		
	}
	
	public void take() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"aaaaa",5));
		personas.add(new Persona(1,"bbbbb",6));
		personas.add(new Persona(3,"ccccc",7));
		personas.add(new Persona(4,"ddddd",8));
		
		Flux.fromIterable(personas)
		.take(1)
		.subscribe(p-> log.info(p.toString()));
	}
	
	public void takeLast() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"aaaaa",5));
		personas.add(new Persona(1,"bbbbb",6));
		personas.add(new Persona(3,"ccccc",7));
		personas.add(new Persona(4,"ddddd",8));
		
		Flux.fromIterable(personas)
		.takeLast(1)
		.subscribe(p-> log.info(p.toString()));
	}
	
	public void skip() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"aaaaa",5));
		personas.add(new Persona(1,"bbbbb",6));
		personas.add(new Persona(3,"ccccc",7));
		personas.add(new Persona(4,"ddddd",8));
		
		Flux.fromIterable(personas)
		.skip(1)
		.subscribe(p-> log.info(p.toString()));
	}
	
	public void skipLast() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"aaaaa",5));
		personas.add(new Persona(1,"bbbbb",6));
		personas.add(new Persona(3,"ccccc",7));
		personas.add(new Persona(4,"ddddd",8));
		
		Flux.fromIterable(personas)
		.skipLast(1)
		.subscribe(p-> log.info(p.toString()));
	}
	
	
	

	
	private static final Logger log = LoggerFactory.getLogger(Filtrado.class);
}
