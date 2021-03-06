package com.reactor;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reactor.filtrado.Filtrado;
import com.reactor.model.Persona;
import com.reactor.operador.combinacion.Combinacion;
import com.reactor.operador.condicional.Condicional;
import com.reactor.operador.creacion.Creacion;
import com.reactor.operador.error.ErrorOp;
import com.reactor.operador.matematico.Matematico;
import com.reactor.operador.transformacion.Transformacion;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//POR SER UNA APP EN CONSOLA, SE IMPLEMENTA CommandLineRunner

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);		
	}

	//EN ESTE MÉTODO SE PONE LA LÓGICA Q SE QUIERE EJECUTAR. EN ESTE CASO EJECUTAMOS 2 FLUJOS DE PERSONA. 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//EJECUTAMOS LOS FLUJOS
				reactor();
				rxjava2();
				mono();
				flux();
				fluxMono();
				Creacion app = new Creacion();
				app.range();
				app.repeat();
				app.repeat2();
				Transformacion tr = new Transformacion();
				tr.map();
				tr.map2();
				tr.map3();
				tr.flatMap();
				tr.groupBy();
				Filtrado filter = new Filtrado();
				filter.filter();
				filter.distinc();
				filter.distinc2();
				filter.take();
				filter.takeLast();
				filter.skip();
				filter.skipLast();
				Combinacion combinacion = new Combinacion();
				combinacion.merge();
				combinacion.merge2();
				combinacion.zip();
				combinacion.zipWith();
				combinacion.zipWith2();
				ErrorOp error = new ErrorOp();
				error.retry();
				error.errorReturn();
				error.errorResume();
				error.errorMap();
				Condicional condicional = new Condicional();
				condicional.defaultIfEmpty();
				condicional.defaultIfEmpty2();
				condicional.takeUntil();
				condicional.timeOut();
				Matematico matematico = new Matematico();
				matematico.average();
				matematico.count();
				matematico.min();
				matematico.sum();
				matematico.summarizing();
	}
	

	
	//FLUJO CON SPRING
	//MONO REPRESENTA EL FLUJO DE UN ELEMENTO.
	//CON SUBSCRIBE() : AGREGAMOS EL FLUJO DE DATOS A LA CONSOLA.
	//.doOnNext () : MÉTODO PARA HACER PROCESOS DE DEPURACIÓN O GENERAR ALGÚN MECANISMO MIENTRAS VAN LLEGANDO LOS DATOS.
	public void reactor() {
		Mono.just(new Persona(1, "Pig", 4))
		.doOnNext(p -> {
			//LÓGICA ADICIONAL
			log.info("[REACTOR] Persona: " + p);
		})
		.subscribe(p -> log.info("[REACTOR] Persona: " + p));
	}
	
	//FLUJO CON JAVA
	public void rxjava2() {
		Observable.just(new Persona(2, "Dog", 5))
		.doOnNext(p -> log.info("[REACTOR] Persona: " + p))
		.subscribe(p -> log.info("[RxJava2] Persona: " + p));;
	}
	
	//MONO: REPRESENTA UN FLUJO DE DATOS DE TIPO ASYNCRONO QUE INDICA LA REPRESENTACIÓN DE UN SOLO ELEMENTO
	public void mono() {
		Mono.just(new Persona(3,"Cat",3)).subscribe(p -> log.info(p.toString()));
	}
	
	//MONO: REPRESENTA UN FLUJO DE DATOS DE TIPO ASYNCRONO QUE INDICA LA REPRESENTACIÓN DE MÁS DE UN ELEMENTO
	public void flux() {
		List<Persona> personas = new ArrayList<>(); 
		personas.add(new Persona(4, "Rabbit", 9));
		personas.add(new Persona(5, "Bat", 2));
		personas.add(new Persona(6, "Mouse", 1));
		
		//PARA CREAR FLUJO DE DATOS ASÍNCRONO CON LA COLECCIÓN
		Flux.fromIterable(personas).subscribe(p -> log.info(p.toString()));
	}
	
	
	//MÉTODO Q PASA DE FLUX A MONO
	public void fluxMono() {
		List<Persona> personas = new ArrayList<>(); 
		personas.add(new Persona(7, "Jirafa", 20));
		personas.add(new Persona(8, "Zebra", 10));
		personas.add(new Persona(9, "Impala", 4));
		//ALMACENAMOS LOS DATOS EN UNA VARIABLE FLUX 
		Flux <Persona> fx = Flux.fromIterable(personas);
		//TRANSFORMA A LOS DATOS COMO SI TODO FUESE UN SOLO FLUJO DE INFORMACIÓN. UNA SOLA LISTA.
		fx.collectList().subscribe(lista -> log.info(lista.toString()));
		
		
	}
	
	
	
	
	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);
}
