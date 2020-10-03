package com.demoHibernate.inheritance.singleTable;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.demoHibernate.demoHib.ExampleRunner;

@Component(value = "singleTable")
public class SingleTableAppRunner implements ExampleRunner{

	/*
	 * @Autowired private DebitAccountRepository debitAccountRepository;
	 * 
	 * @Autowired private CreditAccountRepository creditAccountRepository;
	 */
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	@Transactional
	public  void run(ApplicationContext ctx) {
			DebitAccount debitAccount = new DebitAccount();
			debitAccount.setOwner( "John Doe" );
			debitAccount.setBalance( BigDecimal.valueOf( 100 ) );
			debitAccount.setInterestRate( BigDecimal.valueOf( 1.5d ) );
			debitAccount.setOverdraftFee( BigDecimal.valueOf( 25 ) );

		
		  CreditAccount creditAccount = new CreditAccount(); 
		  creditAccount.setOwner( "Jessica Mole" ); creditAccount.setBalance( BigDecimal.valueOf( 1000 ) ); 
		  creditAccount.setInterestRate( BigDecimal.valueOf( 1.9d ) ); 
		  creditAccount.setCreditLimit(BigDecimal.valueOf( 5000 ) );
		  
		  entityManager.persist(creditAccount); entityManager.persist(debitAccount);
			 
	}

}
