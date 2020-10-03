package com.demoHibernate.identifiers.mapsId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity(name = "person_details")
public class PersonDetails {

	@Id
	Long id;
	
	@Column(name="nickname")
	private String nickName;

	@Override
	public String toString() {
		return "PersonDetails [nickName=" + nickName + "]";
	}

	@OneToOne
	@MapsId
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
