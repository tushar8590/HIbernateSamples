package com.demoHibernate.identifiers.compositePrimaryKey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, PK>{

}
