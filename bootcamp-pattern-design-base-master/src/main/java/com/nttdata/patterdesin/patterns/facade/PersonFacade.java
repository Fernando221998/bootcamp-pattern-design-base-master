package com.nttdata.patterdesin.patterns.facade;

import java.util.List;

import com.nttdata.patterdesin.patterns.domain.Person;

public class PersonFacade {
	
private final List<Person> personas;
	
	public PersonFacade() {
		personas = List.of(
				new Person("Fernando", 45),
				new Person("Antonio", 28),
				new Person("Pepe", 24),
				new Person("Laura", 12)
				);
	}
	
	public List<Person> getPersonsEntreEdad(int min, int max) {
		List<Person> personasEncontradas = personas.stream()
			.filter(x-> x.getAge() >= min && x.getAge() <= max).toList();
		return personasEncontradas;
	}

}
