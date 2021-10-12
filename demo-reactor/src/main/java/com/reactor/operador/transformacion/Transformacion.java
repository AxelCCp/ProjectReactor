package com.reactor.operador.transformacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactor.DemoReactorApplication;
import com.reactor.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Transformacion {

	//OPERADORES DE TRANSFORMACIÓN
	public void map() {
		List <Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Nardiunus",2));
		personas.add(new Persona(2,"Kaohuak",5));
		personas.add(new Persona(3,"Zimlak",7));
		personas.add(new Persona(4,"Fronox",8));
		Flux.fromIterable(personas)
			//TRANSFORMAMOS LOS ELEMENTOS QUE HAY EN ESTE FLUJO ...SE LE SUMA 10 A LA EDAD.
			.map(p -> {
				p.setEdad(p.getEdad() + 10);
				return p;
			})
			.subscribe(p -> log.info(p.toString()));
	}
	
	
	public void map2() {
		Flux <Integer> fx = Flux.range(0,10);
		fx.subscribe(x -> log.info("X : " + x));
	}
	
	public void map3() {
		Flux <Integer> fx = Flux.range(0,10);
		Flux <Integer> fx2 = fx.map(y -> y + 10);
		fx2.subscribe(y -> log.info("Y : " + y));
	}
	
	//MÉTODO QUE TRANSFORMA FLUJOS DE DATOS Y QUE PIDE COMO RETORNO OTRO FLUJO DE DATOS
	public void flatMap() {
		List <Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Nardiunus",2));
		personas.add(new Persona(2,"Kaohuak",5));
		personas.add(new Persona(3,"Zimlak",7));
		personas.add(new Persona(4,"Fronox",8));
		
		Flux.fromIterable(personas)
			.flatMap(p -> {
				p.setEdad(p.getEdad() + 10);
				return Mono.just(p);
			})
			.subscribe(p -> log.info(p.toString()));
	}
	
	
	//MÉTODO QUE AGRUPA SEGÚN UNA VARIABLE
	public void groupBy() {
		List <Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Nardiunus",2));
		personas.add(new Persona(1,"Kaohuak",5));
		personas.add(new Persona(3,"Zimlak",7));
		personas.add(new Persona(4,"Fronox",8));
		
		Flux.fromIterable(personas) 
			//.groupBy(p -> p.getIdPersona()) 				// ESTO ES LO MISMO QUE  groupBy(Persona::getIdPersona)
			.groupBy(Persona::getIdPersona)                 // groupBy() : AGRUPA DE ACUERDO A LA CARACTERÍSTICA QUE SE INDICA EN LOS (). LA AGRUPACIÓN ES EN DIFERENTES FLUX.
			.flatMap(idFlux -> idFlux.collectList())		//LUEGO EL FLUX SE RECOLECTA COMO UNA LISTA.
			.subscribe(x -> log.info(x.toString()));
	}
	
	
	
	
	
	
	
	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);
}
