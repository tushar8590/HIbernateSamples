package com.demoHibernate.identifiers.compositePrimaryKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demoHibernate.demoHib.ExampleRunner;

@Component(value = "compositePrimary")
public class CompositePrimaryKeyRunner implements ExampleRunner{

	@Autowired
	private SystemUserRepository repo;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = false)
	public void run(ApplicationContext ctx) {
		PK pk = new PK("systemA","user1");
		SystemUser su = new SystemUser();
		su.setName("Tushar");
		su.setPk(pk);
		repo.save(su);
	}

}
