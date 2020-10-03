package com.demoHibernate.demoHib.pr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.demoHibernate.demoHib.ExampleRunner;
import com.demoHibernate.identifiers.mapsId.PersonRepository;

@Component("prRunner")
public class PrRunner implements ExampleRunner {

	@Autowired
	PersonRepository personRepo;
	@Override
	public void run(ApplicationContext ctx) {
		System.out.println(personRepo.doesPersonExists(122L));
	}

}
