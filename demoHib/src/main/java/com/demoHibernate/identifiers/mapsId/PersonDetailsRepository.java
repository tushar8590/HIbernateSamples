package com.demoHibernate.identifiers.mapsId;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDetailsRepository extends CrudRepository<PersonDetails, Long>{

}
