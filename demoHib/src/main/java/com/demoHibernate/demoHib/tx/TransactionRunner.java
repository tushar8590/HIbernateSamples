package com.demoHibernate.demoHib.tx;


import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PessimisticLockException;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.demoHibernate.demoHib.ExampleRunner;
import com.demoHibernate.inheritance.mappedSuperclass.CustomerEntity;

@Component(value="txRunner")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TransactionRunner implements ExampleRunner{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@org.springframework.transaction.annotation.Transactional()
	public void run(ApplicationContext ctx) {
		CustomerEntity cust = em.find(CustomerEntity.class, 100L);
		em.lock(cust, LockModeType.PESSIMISTIC_WRITE);
		em.refresh(cust);
		if(cust.getFirstName().equalsIgnoreCase("Yogesh")) {
			cust.setFirstName("tushar");
		} else {
			throw new PessimisticLockException(); 
		}
	}

	
	public void readOnlyTest() {
		
	}
}
