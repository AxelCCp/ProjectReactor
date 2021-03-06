package com.reactor.operador.creacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactor.model.Persona;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Creacion {

	private final static Logger log =  LoggerFactory.getLogger(Creacion.class);
	
	
	//
	public void justFrom() {
		Mono.just(new Persona (1,"Gato", 7));
		//Flux.fromIterable(coleccion);
		//Observable.just(item);
	}
	
	//PARA EXPRESAR FLUJOS VACÍOS
	public void empty() {
		Mono.empty();
		Flux.empty();
		Observable.empty();
	}
	
	//PARA FLUJO DE DATOS A PARTIR DE UN RANGO DE NÚMEROS
	public void range() {
		//RANGE(NÚMERO EN EL QUE SE INICIA(MAYOR O IGUAL A 0) ,  NÚMERO EN EL QUE FINALIZA(MENOR QUE 3))
		//CON LA VARIABLE ITERABLE "i" SE RECORRE LA INFO 
	Flux.range(0, 3).doOnNext(i -> log.info("i : " + i)).subscribe();
	}
	
	
	//PARA REPETIR UN FLUJO DE DATOS
	public void repeat() {
		List <Persona> personas  = new ArrayList();
		personas.add(new Persona(1,"Conejo",4));
		personas.add(new Persona(2,"Tigre",7));
		personas.add(new Persona(3,"Dragon",3));
		personas.add(new Persona(4,"Mono",4));
		personas.add(new Persona(5,"Perro",7));
		Flux.fromIterable(personas).repeat(3).subscribe(p -> log.info(p.toString()));
			
	}
	
	public void repeat2() {
		Mono.just(new Persona(10,"Ratón",7)).repeat(5).subscribe(p -> log.info(p.toString()));
		
	}
	
}
