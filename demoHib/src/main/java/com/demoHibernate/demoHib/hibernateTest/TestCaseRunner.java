package com.demoHibernate.demoHib.hibernateTest;

import static org.hibernate.testing.transaction.TransactionUtil.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;

import com.demoHibernate.demoHib.ExampleRunner;
public class TestCaseRunner implements ExampleRunner {

	
	@PersistenceContext
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public void run(ApplicationContext ctx) {
		EntityManager entityManager = getOrCreateEntityManager();

		  doInJPA( this::entityManagerFactory, entityManager -> {
			  entityManager.persist( item ); assertTrue( entityManager.contains( item ) );
		  } );
		 
	}

}
