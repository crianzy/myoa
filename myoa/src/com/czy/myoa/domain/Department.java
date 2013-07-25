package com.czy.myoa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 部门
 * 
 * @author chen9_000
 * 
 */
public class Department implements Serializable {

	private static final long serialVersionUID = -7383250044344983639L;
	private Long id;
	private String departmentName;
	private String description;

	private Department parent;
	private Set<Department> children = new HashSet<Department>();
	private Set<User> users = new HashSet<User>();

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
	}

}
