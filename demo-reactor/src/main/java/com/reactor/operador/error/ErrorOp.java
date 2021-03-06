package com.reactor.operador.error;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.reactor.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class ErrorOp {
	
	public void retry() {
		
			List<Persona> personas = new ArrayList<>();
			personas.add(new Persona(1,"Tox",5));
			personas.add(new Persona(1,"Zim",6));
			personas.add(new Persona(3,"Diplodocus",7));
			personas.add(new Persona(4,"Sr.Tolk",8));	
			
			Flux.fromIterable(personas)
				.concatWith(Flux.error(new RuntimeException("Un Error")))
				//retry(1) : REPITE, 1 VEZ, LA LECTURA DEL CÓDIGO DEL MÉTODO public void retry(), PARA VER QUE ESTÁ PASANDO.  
				.retry(1)
				.doOnNext(x -> log.info(x.toString()))
				.subscribe();	
	}
	
	public void errorReturn() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Ichinix",5));
		personas.add(new Persona(1,"Vaural",6));
		personas.add(new Persona(3,"Protón",7));
		personas.add(new Persona(4,"Nujiel",8));
		personas.add(new Persona(4,"PeterLikeATurtle",8));
		
		Flux.fromIterable(personas)
		.concatWith(Flux.error(new RuntimeException("UN ERROR")))
		.onErrorReturn(new Persona(0, "xxx",99))
		.subscribe(x -> log.info(x.toString()));
		
	}
	
	public void errorResume() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Uva",5));
		personas.add(new Persona(1,"Pera",6));
		personas.add(new Persona(3,"Manzana",7));
		personas.add(new Persona(4,"Zanahoria",8));	
		Flux.fromIterable(personas)
		.concatWith(Flux.error(new RuntimeException("UN ERROR")))
		.onErrorResume(e -> Mono.just(new Persona(0,"xxx", 99)))
		.subscribe(x -> log.info(x.toString()));	
	}
	
	public void errorMap() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Najanja",5));
		personas.add(new Persona(1,"Guinda",6));
		personas.add(new Persona(3,"Sandía",7));
		personas.add(new Persona(4,"Papaya",6));
		Flux.fromIterable(personas)
		.onErrorMap(e -> new InterruptedException(e.getMessage()))
		.subscribe(x -> log.info(x.toString()));	
	}
	
	
	private static final Logger log = LoggerFactory.getLogger(ErrorOp.class);
}
