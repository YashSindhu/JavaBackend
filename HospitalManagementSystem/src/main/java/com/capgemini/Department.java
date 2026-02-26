package com.capgemini;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String headDoctorName;

    // ========== BI 1:N (inverse side) ==========
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Doctor> doctors = new ArrayList<>();

    public Department() {}

    public Department(String name, String location, String headDoctorName) {
        this.name = name;
        this.location = location;
        this.headDoctorName = headDoctorName;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getHeadDoctorName() { return headDoctorName; }
    public void setHeadDoctorName(String headDoctorName) { this.headDoctorName = headDoctorName; }

    public List<Doctor> getDoctors() { return doctors; }

    // ------ Helper Methods ------
    public void addDoctor(Doctor d) {
        doctors.add(d);
        d.setDepartment(this);
    }

    public void removeDoctor(Doctor d) {
        doctors.remove(d);
        d.setDepartment(null);
    }
}
