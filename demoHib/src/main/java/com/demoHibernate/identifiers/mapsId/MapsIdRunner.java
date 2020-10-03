package com.demoHibernate.identifiers.mapsId;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demoHibernate.demoHib.ExampleRunner;

@Component(value = "mapsIdRunner")
public class MapsIdRunner implements ExampleRunner{

	@Autowired
	private PersonDetailsRepository personDetailsRepository;
	
	@Autowired
	private PersonRepository personRepo;
	
	@PersistenceContext	
	private EntityManager em;
	@Override
	@Transactional
	public void run(ApplicationContext ctx) {
		
		/*
		 * Person person = new Person(); //person.setId( 1L );
		 * person.setRegNumber("LLL1223233"); person = this.savePerson(person);
		 * 
		 * PersonDetails personDetails = new PersonDetails(); personDetails.setNickName(
		 * "ショッピング" ); personDetails.setPerson( person ); personDetails =
		 * this.savePersonDetails(personDetails); System.out.println("Done");
		 * 
		 * 
		 * List<PersonDetails> pd = (List<PersonDetails>)
		 * personDetailsRepository.findAll(); pd.forEach(System.out::println);
		 * 
		 */
		  // JPQL with rownumber
		  Query query = em.createNativeQuery("select reg_NUMBER,rownumber from (SELECT reg_NUMBER, row_number() over(partition by id order by id desc) as rownumber from Person)");
		
		/*
		 * Map<String,BigDecimal> persons = (Map<String,
		 * BigDecimal>)query.getResultList().stream().collect( Collectors.toMap( tuple->
		 * (((String)((Tuple) tuple).get("reg_NUMBER"))), tuple ->((((Tuple)
		 * tuple).get("rownumber"))) ));;
		 */
		  final List resultList = query.getResultList();
		  Map<String,Long> map = new HashMap<>();
		  resultList.forEach(l-> {
			  Object[] elem = (Object[]) l;
			  map.put(elem[0].toString(),Long.parseLong(elem[1].toString()));
		  });
		  
		  map.forEach((k,v) -> {
			  System.out.println(k+ " "+ v);
		  });
	}
	
	@Transactional
	public Person savePerson(Person p) {
		 return personRepo.save( p );
	}

	@Transactional
	public PersonDetails savePersonDetails(PersonDetails p) {
		 return personDetailsRepository.save( p );
	}
	
}
