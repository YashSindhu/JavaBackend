package com.capgemini;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate recordDate;
    private String diagnosis;
    private String notes;

    public MedicalRecord() {}

    public MedicalRecord(LocalDate recordDate, String diagnosis, String notes) {
        this.recordDate = recordDate;
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSummary() {
        return diagnosis + " - " + notes;
    }
}