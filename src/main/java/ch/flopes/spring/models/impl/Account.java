package ch.flopes.spring.models.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {
	
	@OneToMany(mappedBy = "account")
	private Set<Bookmark> bookmaks = new HashSet<Bookmark>();

	@Id
	@JsonIgnore
	@GeneratedValue
	private Long id;
	
	public Set<Bookmark> getBookmaks() {
		return bookmaks;
	}

	public void setBookmaks(Set<Bookmark> bookmaks) {
		this.bookmaks = bookmaks;
	}

	public String getUsername() {
		return username;
	}

	@JsonIgnore
	private String password;
	private String username;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookmaks == null) ? 0 : bookmaks.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Account other = (Account) obj;
		if (bookmaks == null) {
			if (other.bookmaks != null)
				return false;
		} else if (!bookmaks.equals(other.bookmaks))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


}
