package com.autolease.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity implements GrantedAuthority {

	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
	@Override
	public String getAuthority() {
		return name;
	}
}
