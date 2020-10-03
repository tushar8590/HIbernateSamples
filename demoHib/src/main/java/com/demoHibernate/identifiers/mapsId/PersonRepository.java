package com.demoHibernate.identifiers.mapsId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

	@Query(value="select case when count(*) > 0 then true else false end  from person  where id = :id")
	Boolean doesPersonExists(Long id);
}
