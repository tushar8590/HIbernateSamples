package com.demoHibernate.demoHib.jpaMapResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demoHibernate.demoHib.ExampleRunner;

@Component(value = "mapResultRunner")
public class MapResultRunner implements ExampleRunner{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void run(ApplicationContext ctx) {
		
		  Map<String,String> data = (Map<String, String>) em.createNativeQuery(
		  "select first_Name as fname , last_Name as lname from customer ",Tuple.
		  class).getResultList().stream()
				  .collect( Collectors.toMap(
						  tuple -> ((String)((Tuple) tuple).get("fname")).toString(),
						  tuple -> ((String)((Tuple) tuple).get("fname")).toString()
						  ));
		 
		
		System.out.println(data.get("tushar"));	
	}

}
