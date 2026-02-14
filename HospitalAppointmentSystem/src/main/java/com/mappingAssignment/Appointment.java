package com.mappingAssignment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	private int id;
	private String visDate;
	private double fee;
	
	@ManyToOne
	private Patient patient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVisDate() {
		return visDate;
	}

	public void setVisDate(String visDate) {
		this.visDate = visDate;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double newFee) {
		this.fee = newFee;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
