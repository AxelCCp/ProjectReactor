package com.reactor.operador.matematico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.reactor.model.Persona;
import reactor.core.publisher.Flux;

public class Matematico {
	
	//FUNCIÓN QUE PERMITE OBTENER PROMEDIO DE UN CONJUNTO DE DATOS
	public void average() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Alcayota",5));
		personas.add(new Persona(1,"Puerro",6));
		personas.add(new Persona(3,"Cebollín",7));
		personas.add(new Persona(4,"Ajo",6));
		Flux.fromIterable(personas)
		.collect(Collectors.averagingInt(p -> p.getIdPersona()))   //SE RECOLECTA LA INFO CON COLLECT DEL ID.
		.subscribe(x -> log.info(x.toString()));
	}
	
	//SE CUENTAN LOS ELEMENTOS DE UN FLUJO
	public void count() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Betarraga",5));
		personas.add(new Persona(1,"Melón",6));
		personas.add(new Persona(3,"Durazno",7));
		personas.add(new Persona(4,"Damasco",6));
		Flux.fromIterable(personas)
		.count()
		.subscribe(x -> log.info("Cantidad: " + x ));	
	}
	
	//PARA ENCONTRAR EL VALOR MÍNIMO DE UN FLUJO DE DATOS
	public void min() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Betarraga",5));
		personas.add(new Persona(1,"Melón",6));
		personas.add(new Persona(3,"Durazno",7));
		personas.add(new Persona(4,"Damasco",6));
		Flux.fromIterable(personas)
		.collect(Collectors.minBy(Comparator.comparing(p->p.getEdad())))
		.subscribe(p -> log.info(p.get().toString()));	//CON GET() SE OBTIENE EL RESULTADO TRAS LA COMPARACIÓN.
	}
	
	//SUMA LOS ELEMENTOS DE UN FLUJO DE DATOS
	public void sum() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Guayaba",5));
		personas.add(new Persona(1,"Palta",6));
		personas.add(new Persona(3,"Limón",7));
		personas.add(new Persona(4,"Mandarina",6));
		Flux.fromIterable(personas)
		.collect(Collectors.summingInt(p -> p.getEdad()))
		.subscribe(x -> log.info("Suma: " + x ));	
	}
	
	//ENTREGA RESUMEN DE ALGUNAS OPERACIONES ARITMÉTICAS SEGÚN LOS DATOS DE LA LISTA.
	public void summarizing() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Guayaba",5));
		personas.add(new Persona(1,"Palta",6));
		personas.add(new Persona(3,"Limón",7));
		personas.add(new Persona(4,"Mandarina",6));
		Flux.fromIterable(personas)
		.collect(Collectors.summarizingInt(p->p.getEdad()))
		.subscribe(x -> log.info("Resumen:" + x ));
	}
	
	private static final Logger log = LoggerFactory.getLogger(Matematico.class); 
}
