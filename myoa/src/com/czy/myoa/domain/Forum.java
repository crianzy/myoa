package com.czy.myoa.domain;

import java.io.Serializable;

public class Forum implements Serializable {

	private static final long serialVersionUID = 341095758705879807L;

	private Long id;
	private String name;
	private String description;
	private int position;// 排序用的位置号

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
