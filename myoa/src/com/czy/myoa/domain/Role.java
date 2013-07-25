package com.czy.myoa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 岗位
 * 
 * @author chen9_000
 * 
 */
public class Role implements Serializable {

	private static final long serialVersionUID = -1936532138257644515L;

	private Long id;
	private String rolename;
	private String description;
	private Set<User> users = new HashSet<User>();
	private Set<Privilege> privileges = new HashSet<Privilege>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}
