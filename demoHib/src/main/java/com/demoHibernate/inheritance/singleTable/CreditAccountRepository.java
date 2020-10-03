package com.demoHibernate.inheritance.singleTable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CreditAccountRepository extends CrudRepository<CreditAccount,Long>{

}
