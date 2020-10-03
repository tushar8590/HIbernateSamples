package com.demoHibernate.identifiers.compositePrimaryKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "systemuser")
@Entity
public class SystemUser {
	@EmbeddedId
	private PK pk;
	@Column(name="name")
	private String name;

	public PK getPk() {
		return pk;
	}

	public void setPk(PK pk) {
		this.pk = pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
