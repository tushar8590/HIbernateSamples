package com.demoHibernate.identifiers.mapsId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="person")
public class Person {
	
		@Id
		@GeneratedValue
	    private Long id;

	   // @NaturalId
	    @Column(name="reg_NUMBER")
	    private String regNumber;

	    public String getRegNumber() {
			return regNumber;
		}


		public void setRegNumber(String regNumber) {
			this.regNumber = regNumber;
		}


		public Person() {}


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

}
