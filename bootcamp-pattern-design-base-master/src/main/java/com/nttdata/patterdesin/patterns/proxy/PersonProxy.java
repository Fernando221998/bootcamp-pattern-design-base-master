package com.nttdata.patterdesin.patterns.proxy;

import com.nttdata.patterdesin.patterns.decorator.PersonInterface;
import com.nttdata.patterdesin.patterns.domain.Person;

public class PersonProxy extends AbstractPersonProxy {
	
	public PersonProxy(PersonProxyInterface person) {
		super(person);
	}

	public  void before() {
		System.out.println("Antes");
	}

	public  void after() {
		System.out.println("Despues");
	}

}
