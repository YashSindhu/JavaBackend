package com.prac;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    private int studentId;

    private String name;
    private String email;
    private String branch;

    @OneToOne
    private AadharCard aadhar;

    @OneToOne
    private HostelRoom hostelRoom;
    
    // Getters & Setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public AadharCard getAadhar() {
		return aadhar;
	}

	public void setAadhar(AadharCard aadhar) {
		this.aadhar = aadhar;
	}

	public HostelRoom getHostelRoom() {
		return hostelRoom;
	}

	public void setHostelRoom(HostelRoom hostelRoom) {
		this.hostelRoom = hostelRoom;
	}
        
}

