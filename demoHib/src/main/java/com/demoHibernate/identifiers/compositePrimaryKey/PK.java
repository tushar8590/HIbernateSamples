package com.demoHibernate.identifiers.compositePrimaryKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PK implements Serializable{
		
	  @Column(name="subsystem")
	  private String subsystem;

	  @Column(name="username")
	  private String username;

	  public PK(String subsystem, String username) {
	     this.subsystem = subsystem;
	     this.username = username;
	  }

	  private PK() {
	    }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((subsystem == null) ? 0 : subsystem.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PK other = (PK) obj;
			if (subsystem == null) {
				if (other.subsystem != null)
					return false;
			} else if (!subsystem.equals(other.subsystem))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		public String getSubsystem() {
			return subsystem;
		}

		public void setSubsystem(String subsystem) {
			this.subsystem = subsystem;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
}
