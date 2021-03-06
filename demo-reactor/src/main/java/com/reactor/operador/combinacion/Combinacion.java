package com.reactor.operador.combinacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactor.model.Persona;
import com.reactor.model.Venta;

import reactor.core.publisher.Flux;

public class Combinacion {

	public void merge() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"aaaaa",5));
		personas.add(new Persona(1,"bbbbb",6));
		personas.add(new Persona(3,"ccccc",7));
		personas.add(new Persona(4,"ddddd",8));
		
		List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona(1,"eeee",5));
		personas2.add(new Persona(1,"ffff",6));
		personas2.add(new Persona(3,"gggg",7));
		personas2.add(new Persona(4,"hhhh",8));
		
		//2 FLUX
		Flux <Persona> fx1 = Flux.fromIterable(personas);
		Flux <Persona> fx2 = Flux.fromIterable(personas2);
		//COMBINACIÓN DE FLUX : IMPRIME AMBAS LISTAS
		Flux.merge(fx1,fx2).subscribe(p -> log.info(p.toString()));
		
	}
	
	public void merge2() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"fronox",5));
		personas.add(new Persona(1,"kaohuac",6));
		personas.add(new Persona(3,"zimlak",7));
		personas.add(new Persona(4,"flabuyín",8));
		List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona(1,"Aldebarán",5));
		personas2.add(new Persona(1,"valogumgar",6));
		personas2.add(new Persona(3,"Orion",7));
		personas2.add(new Persona(4,"Neptuno",8));
		List <Venta> venta = new ArrayList<>();
		venta.add(new Venta(1, LocalDateTime.now()));
		
		Flux <Persona> fx1 = Flux.fromIterable(personas);
		Flux <Persona> fx2 = Flux.fromIterable(personas2);
		Flux <Venta> fx3 = Flux.fromIterable(venta);
		
		Flux.merge(fx1,fx2,fx3).subscribe(p -> log.info(p.toString()));
	}
	
	public void zip() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"fronox",5));
		personas.add(new Persona(1,"kaohuac",6));
		personas.add(new Persona(3,"zimlak",7));
		personas.add(new Persona(4,"flabuyín",8));
		List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona(1,"Aldebarán",5));
		personas2.add(new Persona(1,"valogumgar",6));
		personas2.add(new Persona(3,"Orion",7));
		personas2.add(new Persona(4,"Neptuno",8));
		List <Venta> venta = new ArrayList<>();
		venta.add(new Venta(1, LocalDateTime.now()));
		
		Flux <Persona> fx1 = Flux.fromIterable(personas);
		Flux <Persona> fx2 = Flux.fromIterable(personas2);
		Flux <Venta> fx3 = Flux.fromIterable(venta);
		
		Flux.zip(fx1, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1,p2))
		.subscribe(p -> log.info(p));
	}
	
	
	public void zip2() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"fronox",5));
		personas.add(new Persona(1,"kaohuac",6));
		personas.add(new Persona(3,"zimlak",7));
		personas.add(new Persona(4,"flabuyín",8));
		List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona(1,"Aldebarán",5));
		personas2.add(new Persona(1,"valogumgar",6));
		personas2.add(new Persona(3,"Orion",7));
		personas2.add(new Persona(4,"Neptuno",8));
		List <Venta> venta = new ArrayList<>();
		venta.add(new Venta(1, LocalDateTime.now()));
		
		Flux <Persona> fx1 = Flux.fromIterable(personas);
		Flux <Persona> fx2 = Flux.fromIterable(personas2);
		Flux <Venta> fx3 = Flux.fromIterable(venta);
		
		Flux.zip(fx1,fx2,fx3).subscribe(x -> log.info(x.toString()));	
	}
	
	public void zipWith() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"fronox",5));
		personas.add(new Persona(1,"kaohuac",6));
		personas.add(new Persona(3,"zimlak",7));
		personas.add(new Persona(4,"flabuyín",8));
		List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona(1,"Aldebarán",5));
		personas2.add(new Persona(1,"valogumgar",6));
		personas2.add(new Persona(3,"Orion",7));
		personas2.add(new Persona(4,"Neptuno",8));
		List <Venta> venta = new ArrayList<>();
		venta.add(new Venta(1, LocalDateTime.now()));
		
		Flux <Persona> fx1 = Flux.fromIterable(personas);
		Flux <Persona> fx2 = Flux.fromIterable(personas2);
		Flux <Venta> fx3 = Flux.fromIterable(venta);
		
		fx1.zipWith(fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
		.subscribe(x -> log.info(x.toString()));	
	}
	
	public void zipWith2() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"fronox",5));
		personas.add(new Persona(1,"kaohuac",6));
		personas.add(new Persona(3,"zimlak",7));
		personas.add(new Persona(4,"flabuyín",8));
		List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona(1,"Aldebarán",5));
		personas2.add(new Persona(1,"valogumgar",6));
		personas2.add(new Persona(3,"Orion",7));
		personas2.add(new Persona(4,"Neptuno",8));
		List <Venta> venta = new ArrayList<>();
		venta.add(new Venta(1, LocalDateTime.now()));
		
		Flux <Persona> fx1 = Flux.fromIterable(personas);
		Flux <Persona> fx2 = Flux.fromIterable(personas2);
		Flux <Venta> fx3 = Flux.fromIterable(venta);
		
		fx1.zipWith(fx3, (p1, v1) -> String.format("Flux1: %s, Flux2: %s", p1, v1))
		.subscribe(x -> log.info(x.toString()));	
		
	}
	
	
	private static final Logger log = LoggerFactory.getLogger(Combinacion.class); 	
	
}
