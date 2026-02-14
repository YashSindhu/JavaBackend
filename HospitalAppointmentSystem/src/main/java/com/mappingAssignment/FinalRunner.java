package com.mappingAssignment;

public class FinalRunner {

    public static void main(String[] args) {

        HospitalService service = new HospitalService();

        // Create Medical Record
        MedicalRecord record = new MedicalRecord();
        record.setId(100);
        record.setBloodGroup("O+");
        record.setAllergies("None");

        // Create Patient
        Patient patient = new Patient();
        patient.setId(100);
        patient.setName("Yash");
        patient.setAge(22);
        patient.setContact("9999999999");

        // Register patient
        service.registerPatient(patient, record);

        // Create Appointment
        Appointment appointment = new Appointment();
        appointment.setId(200);
        appointment.setVisDate("2026-02-20");
        appointment.setFee(1200);

        // Assign appointment to patient
        service.assignAppointmentToPatient(appointment, patient);

        System.out.println("All data inserted successfully!");
    }
}
