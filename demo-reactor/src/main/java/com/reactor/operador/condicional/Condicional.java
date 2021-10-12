package com.reactor.operador.condicional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactor.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Condicional {
	
	public void defaultIfEmpty() {
		Mono.empty()  //SE ASUME UN MONO = EMPTY
		//Flux.empty()
		.defaultIfEmpty(new Persona(0,"DEFAULT",99))
		.subscribe(x -> log.info(x.toString()));
	}
	
	
	public void defaultIfEmpty2() {
		Mono.just(new Persona(1,"Piña",1))  //CON ESTO EL DEFAULT NO CORRE.
		//Mono.empty()  
		.defaultIfEmpty(new Persona(0,"DEFAULT",99))
		.subscribe(x -> log.info(x.toString()));
	}
	
	public void takeUntil() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Berenjena",5));
		personas.add(new Persona(1,"Papa",6));
		personas.add(new Persona(3,"Tomate",7));
		personas.add(new Persona(4,"Cebolla",6));
		Flux.fromIterable(personas)
		.takeUntil(p -> p.getEdad()>6)  //EMITE FLUJOS HASTA LOS 6 AÑOS.
		.subscribe(x -> log.info(x.toString()));
	}
	
	public void timeOut() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Alcayota",5));
		personas.add(new Persona(1,"Puerro",6));
		personas.add(new Persona(3,"Cebollín",7));
		personas.add(new Persona(4,"Ajo",6));
		Flux.fromIterable(personas)
		.delayElements(Duration.ofSeconds(3))   //SE AUTOGENERA UNA DEMORA DE 3 SEGUNDOS
		.timeout(Duration.ofSeconds(4)) //TIENE UNA ESPERA MÁXIMA DE 4 SEGUNDOS, SINÓ LANZA UN TIMEOUT.
		.subscribe(x -> log.info(x.toString()));
		
		//PARA PODER VER LOS DATOS EN CONSOLA
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final Logger log = LoggerFactory.getLogger(Condicional.class);
}
