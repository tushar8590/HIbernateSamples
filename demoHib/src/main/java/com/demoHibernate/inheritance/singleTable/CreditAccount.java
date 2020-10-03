package com.demoHibernate.inheritance.singleTable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class CreditAccount extends Account{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	@Column(name="creditlimit")
	private BigDecimal creditLimit;

	    public BigDecimal getCreditLimit() {
	        return creditLimit;
	    }

	    public void setCreditLimit(BigDecimal creditLimit) {
	        this.creditLimit = creditLimit;
	    }
}
