package com.nttdata.patterdesin.patterns.proxy;

public abstract class AbstractPersonProxy implements PersonProxyInterface {
	private PersonProxyInterface person;

	public AbstractPersonProxy(PersonProxyInterface person) {
		this.person = person;
	}

	@Override
	public void realiza() {
		before();
		person.realiza();
		after();
	}

	public abstract void before();

	public abstract void after();

}
