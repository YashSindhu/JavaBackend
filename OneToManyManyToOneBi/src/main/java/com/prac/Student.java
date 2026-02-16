package com.prac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stud2")
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	
	@ManyToOne
	@JoinColumn
	private College college;
	
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
