package com.capgemini;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String licenseNo;

    // ========== BI N:1 ==========
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    // ========== BI M:N (owning side) ==========
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "patient_doctors",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients = new ArrayList<>();

    // ========== UNI 1:N (Doctor → Appointment) ==========
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor() {}

    public Doctor(String name, String specialization, String licenseNo) {
        this.name = name;
        this.specialization = specialization;
        this.licenseNo = licenseNo;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getLicenseNo() { return licenseNo; }
    public void setLicenseNo(String licenseNo) { this.licenseNo = licenseNo; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public List<Patient> getPatients() { return patients; }

    public List<Appointment> getAppointments() { return appointments; }

    // ------ Helper Methods for M:N -------
    public void addPatient(Patient p) {
        patients.add(p);
        p.getDoctors().add(this);
    }

    public void removePatient(Patient p) {
        patients.remove(p);
        p.getDoctors().remove(this);
    }
}
