package com.demoHibernate.inheritance.mappedSuperclass;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demoHibernate.demoHib.ExampleRunner;

@Component(value = "simpleCustomer")
public class SimpleCustomerEntityRunner implements ExampleRunner{
	
@Autowired
private CustomerRepository custRepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = false)
	public void run(ApplicationContext ctx) {
		CustomerEntity cs = new CustomerEntity();
		cs.setId(100L);
		cs.setFirstName("Ellen");
		cs.setLastName("Shaw");
		custRepo.save(cs);
	}

}
