package com.demoHibernate.inheritance.singleTable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity(name="DebitAccount")
public class DebitAccount extends Account{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="overdraftfee")
	private BigDecimal overdraftFee;

    public BigDecimal getOverdraftFee() {
        return overdraftFee;
    }

    public void setOverdraftFee(BigDecimal overdraftFee) {
        this.overdraftFee = overdraftFee;
    }
}
