package com.reactor.operador.transformacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactor.DemoReactorApplication;
import com.reactor.model.Persona;

import reactor.core.publisher.Flux;

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
	
	
	
	
	
	
	
	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);
}