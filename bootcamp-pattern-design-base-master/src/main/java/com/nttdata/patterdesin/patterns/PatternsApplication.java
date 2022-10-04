package com.nttdata.patterdesin.patterns;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nttdata.patterdesin.patterns.decorator.PersonDecorator;
import com.nttdata.patterdesin.patterns.decorator.PersonInterface;
import com.nttdata.patterdesin.patterns.domain.Bussines;
import com.nttdata.patterdesin.patterns.domain.Person;
import com.nttdata.patterdesin.patterns.facade.PersonFacade;
import com.nttdata.patterdesin.patterns.proxy.AbstractPersonProxy;
import com.nttdata.patterdesin.patterns.proxy.PersonProxy;
import com.nttdata.patterdesin.patterns.proxy.PersonProxy;
import com.nttdata.patterdesin.patterns.singleton.PersonSingleton;
import com.nttdata.patterdesin.patterns.singleton.PersonSingletonEnum;

@SpringBootApplication
@ComponentScan(value = "com.nttdata")
public class PatternsApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    private PersonInterface personPrototype;

    public PatternsApplication(PersonInterface personPrototype) {
        this.personPrototype = personPrototype;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatternsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicio...");

        System.out.println("=============================================================================");
        System.out.println("Prácticas con Singleton");
        System.out.println("=============================================================================");
        PersonSingletonEnum.INSTANCE.person().setName("Joselito");
        PersonSingletonEnum.INSTANCE.person().setAge(13);;

        System.out.println(PersonSingletonEnum.INSTANCE.person().getName());
        System.out.println(PersonSingletonEnum.INSTANCE.person().getAge());
        
        PersonSingleton.INSTANCE.setName("Fernando");
        PersonSingleton.INSTANCE.setAge(29);
        
        System.out.println(PersonSingleton.INSTANCE.getName() + " - " + PersonSingleton.INSTANCE);
        
        Bussines bussines = new Bussines();
		bussines.ejecuta();
		
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Prototype");
		System.out.println("=============================================================================");

		Person fernando = new Person("Fernando", 42);
		Person fernandoClon = fernando.clone();

		System.out.println("ID del objeto ismael: " + fernando.getName() + " Edad: " + fernando.getAge() + "- " + fernando);
		System.out.println("ID del objeto ismaelClon: " + fernandoClon.getName() + " Edad: " + fernandoClon.getAge() + " - "
				+ fernandoClon);
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Builder");
		System.out.println("=============================================================================");

		Person per = Person.Builder().name("Fernando").age(152).build();

		System.out.println(per.getName() + " Edad: " + per.getAge() + "- " + per);
		
		System.out.println("=============================================================================");
        System.out.println("Personas entre 20 y 30 años");
        System.out.println("=============================================================================");
        
        PersonFacade facade = new PersonFacade();
        List<Person> foundPersons = facade.getPersonsEntreEdad(20, 30);
        foundPersons.forEach(x -> System.out.println(x.getName()+", edad: "+x.getAge()));
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Decorador");
		System.out.println("=============================================================================");
		
		PersonInterface person2 = Person.Builder().age(42).name("Fernando Cornejo Hernández").build();
		PersonInterface person3 =  new PersonDecorator(person2);
		
		System.out.println("Prototype Name " + person2.getName());
		System.out.println("Prototype Decorated Name " + person3.getName());
		
		System.out.println("Prototype Edad Meses " + person2.getAge());
		System.out.println("Prototype Decorated Edad Días " + person3.getAge());
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Proxy");
		System.out.println("=============================================================================");

		Person entidad = Person.Builder().age(24).name("Fernando Cornejo").build();
		
		AbstractPersonProxy proxy = new PersonProxy(entidad);
		
		proxy.realiza();

        System.out.println("Fin...");
    }
}
